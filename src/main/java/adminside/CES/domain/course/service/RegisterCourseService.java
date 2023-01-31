package adminside.CES.domain.course.service;

import adminside.CES.domain.course.entity.Course;
import adminside.CES.domain.course.entity.RegisterCourse;
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

    // 미구현
    // private final StudentRepository studentRepository
    // private final CourseRepository courseRepository

    public Long register(int studentId, String courseId) {
        // 미구현
        // Student student = studentRepository.findById(studentId);
        // Course course = ~~~
        Student student = new Student();
        student.setId(studentId);

        Course course = new Course();
        course.setCourseId(courseId);

        RegisterCourse registerCourse = new RegisterCourse();
        registerCourse.setRegisterCourse(student, course);

        registerCourseRepository.save(registerCourse);

        return registerCourse.getId();
    }
}
