package adminside.CES.domain.course.service;

import adminside.CES.domain.course.entity.Course;
import adminside.CES.domain.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    public void enrollCourse(Course course) {
        courseRepository.save(course);

    }
}
