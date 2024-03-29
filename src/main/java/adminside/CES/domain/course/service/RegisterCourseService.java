package adminside.CES.domain.course.service;

import adminside.CES.domain.course.entity.Course;
import adminside.CES.domain.course.entity.RegisterCourse;
import adminside.CES.domain.course.repository.RegisterCourseRepository;
import adminside.CES.domain.user.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        //============================
        Student student = new Student();
        student.setId(studentId);

        Course course = new Course();
        course.setCourseId(courseId);
        // ===========================
        RegisterCourse registerCourse = new RegisterCourse();
        registerCourse.setRegisterCourse(student, course);

        registerCourseRepository.save(registerCourse);

        return registerCourse.getId();
    }

    public void cancel() {

    }

    public List<RegisterCourse> findAllByStudent(int studentId) {
        // 미구현
        // Student student = studentRepository.findById(studentId);
        // 테스트용
        Student student = new Student();
        student.setId(studentId);

        List<RegisterCourse> registerCourses = registerCourseRepository.findAllByStudent(student);

        return registerCourses;
    }

    public List<RegisterCourse> findAllByCourse(String courseId) {
        // 미구현
        // Course course = ~~~.findBy~~
        // 테스트용
        Course course = new Course();
        course.setCourseId(courseId);

        List<RegisterCourse> registerCourses = registerCourseRepository.findAllByCourse(course);

        return registerCourses;
    }
}
