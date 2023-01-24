package adminside.CES.domain.user.service;

import adminside.CES.domain.admin.entity.Schedules;
import adminside.CES.domain.admin.repository.ScheduleRepository;
import adminside.CES.domain.course.entity.Course;
import adminside.CES.domain.course.repository.CourseRepository;
import adminside.CES.domain.user.dto.BasketDto;
import adminside.CES.domain.user.entity.Basket;
import adminside.CES.domain.user.repository.BasketRepository;
//import adminside.CES.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
//    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final BasketRepository basketRepository;
    private final ScheduleRepository scheduleRepository;
    public List<Course> getBasket(String userId) {

        return Collections.emptyList();
    }

    public void createBasket(BasketDto dto) {

        Optional<Course> courseById = courseRepository.findById(dto.getCourseId()); // 과목 정보들
        Optional<List<Basket>> basketByStudentIds = basketRepository.findByStudentId(dto.getStudentId()); // 학생에 대한 장바구니 정보들
        System.out.println("basketByStudentId = " + basketByStudentIds.get().get(1).getStudentId());

        Basket basket = Basket.from(dto); //장바구니 객체 생성

        if (courseById.isPresent()) { // 과목이 존재.
            Optional<List<Schedules>> scheduleByCourseIds= scheduleRepository.findByCourseId(dto.getCourseId()); // 현재 담을 과목에 대한 스케줄
            if (scheduleByCourseIds.isPresent()) {//과목 스케줄 존재.
                for (Basket bas : basketByStudentIds.get()) {
                    String courseId = bas.getCourseId(); //현재 사용자가 미리 담아놓은 장바구니에 있는 과목
                    Optional<List<Schedules>> exSchedules = scheduleRepository.findByCourseId(courseId); // 담아놓은 과목 정보들

//                    if (schedule.isPresent()) {
//                        String d= schedule.get().getClassDay();
//                        Time st = schedule.get().getClassStartTime();
//                        Time et = schedule.get().getClassEndTime();
//                        // 비교
//                        String d2 = scheduleByCourseId.get().getClassDay();
//                        Time st2 = scheduleByCourseId.get().getClassStartTime();
//                        Time et2 = scheduleByCourseId.get().getClassEndTime();
//                        if (st < st2 || st > et2) {
//                            //시간표 겹침!
//                        }
//                    }
                }
            }
        }
//        basketRepository.save(basket);

    }
}

