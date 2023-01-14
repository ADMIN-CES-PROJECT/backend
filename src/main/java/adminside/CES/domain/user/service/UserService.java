package adminside.CES.domain.user.service;

import adminside.CES.domain.course.entity.Course;
import adminside.CES.domain.course.repository.CourseRepository;
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
    public List<Course> getBasket(String userId) {

        return Collections.emptyList();
    }

    public void insertBasket(Course course) {
//        Optional<Course> byId = courseRepository.findById(courseId);
        Basket basket = new Basket();
        System.out.println("courseId@@= " + course.getCourseId());
        basket.setCourseId(course.getCourseId());
        basket.setStudentId("201802057");
//        if (byId.isPresent()) {
//            basketRepository.save(basket);
//        }
        basketRepository.save(basket);

    }
}

