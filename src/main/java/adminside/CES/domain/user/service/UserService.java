package adminside.CES.domain.user.service;

import adminside.CES.domain.course.entity.Course;
import adminside.CES.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
//    private final CourseRepository courseRepository;

    public List<Course> getBasket(String userId) {
        return Collections.emptyList();
    }
}

