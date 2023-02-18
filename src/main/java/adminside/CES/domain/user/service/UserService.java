package adminside.CES.domain.user.service;

import adminside.CES.domain.admin.entity.Schedules;
import adminside.CES.domain.admin.repository.ScheduleRepository;
import adminside.CES.domain.course.entity.Course;
import adminside.CES.domain.course.repository.CourseRepository;
import adminside.CES.domain.user.dto.BasketDto;
import adminside.CES.domain.user.entity.Basket;
//import adminside.CES.domain.user.repository.UserRepository;
import adminside.CES.domain.user.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
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

    public List<Basket> getBasket(String userId) {
        Optional<List<Basket>> byStudentId = basketRepository.findByStudentId(userId);
        if (byStudentId.isPresent()) {
            return (byStudentId.get());
        }
        return Collections.emptyList();
    }

    /*
     *
     *
     *
     */
    public boolean createBasket(BasketDto dto) {

        Optional<Course> courseById = courseRepository.findById(dto.getCourseId()); // 장바구니에 담을 과목 정보
        Optional<List<Basket>> basketByStudentIds = basketRepository.findByStudentId(dto.getStudentId()); // 현재 사용자의 장바구니 정보들

        Basket basket = Basket.from(dto); //장바구니 객체 생성

        if (courseById.isPresent()) { // 1. 장바구니에 담을 과목이 존재해야한다.
            Optional<List<Schedules>> scheduleByCourseIds = scheduleRepository.findByCourseId(dto.getCourseId()); // 현재 담을 과목에 대한 스케줄
            if (scheduleByCourseIds.isPresent()) {//2. 장바구니에 담을 과목의 스케줄 존재해야한다.
                for (Basket bas : basketByStudentIds.get()) { // 현재 사용자의 장바구니 객체
                    String courseId = bas.getCourseId(); //현재 사용자가 미리 담아놓은 장바구니에 있는 과목id
                    Optional<List<Schedules>> exSchedules = scheduleRepository.findByCourseId(courseId); // 담아놓은 과목 각각의 스케쥴

                    if (exSchedules.isPresent()) {
                        for (Schedules sch : exSchedules.get()) { // 담겨있는 각각의 과목에 대한 스케줄 확인
                            String d = sch.getClassDay();
                            Time st = Time.valueOf(sch.getClassStartTime());
                            Time et = Time.valueOf(sch.getClassEndTime());
                            // 비교
                            for (Schedules toSchedule : scheduleByCourseIds.get()) { //담을.
                                String d2 = toSchedule.getClassDay();
                                Time st2 = Time.valueOf(toSchedule.getClassStartTime());
                                Time et2 = Time.valueOf(toSchedule.getClassEndTime());
                                System.out.println("et2 = " + et2);
                                System.out.println("st2 = " + st2);
                                System.out.println("st = " + st);
                                System.out.println("et = " + et);
                                if (d2.equals(d)) { // 같은 날짜에.
                                    if (et.equals(et2) || st.equals(st2) || (st.after(st2) && st.before(et2)) || (et.after(st2) && et.before(et2))) { //시작 과 끝 사이에 시작 또는, 시작과 끝 사이에 끝남.
                                        //시간표 겹침!
                                        return false;
                                    }
                                }

                            }

                        }

                    }
                }
            }
        }else{
            return false;
        }

        basketRepository.save(basket);
        return true;
    }
}

