package adminside.CES.domain.user.service;

import adminside.CES.domain.admin.entity.Schedules;
import adminside.CES.domain.admin.repository.ScheduleRepository;
import adminside.CES.domain.course.entity.Course;
import adminside.CES.domain.course.repository.CourseRepository;
import adminside.CES.domain.user.dto.BasketDto;
import adminside.CES.domain.user.entity.Basket;
import adminside.CES.domain.user.entity.Student;
import adminside.CES.domain.user.repository.BasketRepository;
import adminside.CES.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final BasketRepository basketRepository;
    private final ScheduleRepository scheduleRepository;

    public List<Basket> getBasket(Student userId) {
        Optional<List<Basket>> byStudentId = basketRepository.findByStudentId(userId.getId());
        if (byStudentId.isPresent()) {
            return (byStudentId.get());
        }
        return Collections.emptyList();
    }

    public boolean createBasket(BasketDto dto) {
        // 모든 과목의 스케줄 같은 유효성 검사는 굳이 이 비즈니스 로직에서 해야하나 싶은 의문점이 있다.
        // -> 사실 과목 데이터 저장 시 모든 유효성 검사를 끝낸 후 넣었을 거니깐? 보장됨.
        Optional<Course> courseById = courseRepository.findById(dto.getCourseId()); // 장바구니에 담을 과목 정보
        Optional<List<Basket>> basketByStudentIds = basketRepository.findByStudentId(dto.getStudentId()); // 현재 사용자의 장바구니 정보들
//
        if (courseById.isPresent()) { // 1. 장바구니에 담을 과목이 존재해야한다.
            Optional<List<Schedules>> scheduleByCourseIds = scheduleRepository.findByCourseId(dto.getCourseId()); // 현재 담을 과목에 대한 스케줄
            if (scheduleByCourseIds.isPresent()) {//2. 장바구니에 담을 과목의 스케줄 존재해야한다.
                for (Basket bas : basketByStudentIds.get()) { // 현재 사용자의 장바구니 객체
                    String courseId = bas.getCourse().getCourseId(); //현재 사용자가 미리 담아놓은 장바구니에 있는 과목id
                    Optional<List<Schedules>> exSchedules = scheduleRepository.findByCourseId(courseId); // 담아놓은 과목 각각의 스케쥴
                    //리팩토링 요소 -> 현재는 장바구니의 과목 객체 1개당 스케줄데이터를 가져오는 쿼리 1개 발생 == 총 N번 쿼리 요청
                    // -> join 쿼리문을 사용해서 사용자의 장바구니에 담긴 과목들의 모든 스케줄데이터를 가져오는 쿼리문 사용 시 쿼리 요청 1번
                    // => 쿼리 요청을 N번 보내는 것 보다 1번의 쿼리문으로 Join 문을 사용하는 것이 더 빠를 것 이라고 예상됨 ( 요청 작업이 더 느릴테니깐? )

                    if (exSchedules.isPresent()) {
                        schedulesValidation(exSchedules.get(), scheduleByCourseIds.get());
                    }
                }
            }
        } else {
            return false;
        }
        Optional<Student> byId = userRepository.findById(dto.getStudentId());
        Basket basket = Basket.from(courseById.get(), byId.get()); //장바구니 객체 생성
        basketRepository.save(basket);
        return true;
    }

    private boolean schedulesValidation(List<Schedules> origin, List<Schedules> target) {
        for (Schedules sch : origin) { // 담겨있는 각각의 과목에 대한 스케줄 확인
            String originDay = sch.getClassDay();
            Time originSt = Time.valueOf(sch.getClassStartTime());
            Time originEt = Time.valueOf(sch.getClassEndTime());
            // 비교
            for (Schedules toSchedule : target) { //담을.
                String targetDay = toSchedule.getClassDay();
                Time targetSt = Time.valueOf(toSchedule.getClassStartTime());
                Time targetEt = Time.valueOf(toSchedule.getClassEndTime());

                // 같은 날짜에.
                if (targetDay.equals(originDay)
                        && (originEt.equals(targetEt) || originSt.equals(targetSt) ||
                        (originSt.after(targetSt) && originSt.before(targetEt)) ||
                        (originEt.after(targetSt) && originEt.before(targetEt)))) { //시작 과 끝 사이에 시작 또는, 시작과 끝 사이에 끝남.
                    //시간표 겹침!
                    return false;
                }
            }
        }
        return true;
    }

}

