package adminside.CES.domain.course.controller;

import adminside.CES.domain.course.entity.Course;
import adminside.CES.domain.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;


    @PostMapping
    public ResponseEntity<Object> enrollCourse(@RequestBody Course course) {
        courseService.enrollCourse(course);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
