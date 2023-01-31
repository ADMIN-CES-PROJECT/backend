package adminside.CES.domain.course.service;

import adminside.CES.domain.course.repository.RegisterCourseRepository;
import adminside.CES.domain.user.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RegisterCourseService {

    private final RegisterCourseRepository registerCourseRepository;

    // private final StudentRepository studentRepository
    // private final CourseRepository courseRepository

    
}
