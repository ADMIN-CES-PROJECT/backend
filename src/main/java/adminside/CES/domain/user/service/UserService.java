package adminside.CES.domain.user.service;

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

@Service
@RequiredArgsConstructor
public class UserService {
//    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final BasketRepository basketRepository;
    public List<Course> getBasket(String userId) {

        return Collections.emptyList();
    }

    public void insertBasket(BasketDto dto) {
//        Optional<Course> byId = courseRepository.findById(courseId);
        Basket basket = Basket.from(dto);

//        if (byId.isPresent()) {
//            basketRepository.save(basket);
//        }
        basketRepository.save(basket);

    }
}

