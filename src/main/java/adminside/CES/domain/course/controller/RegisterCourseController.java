package adminside.CES.domain.course.controller;

import adminside.CES.domain.course.entity.RegisterCourse;
import adminside.CES.domain.course.service.RegisterCourseService;
import adminside.CES.domain.user.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RegisterCourseController {

    private final RegisterCourseService registerCourseService;

    @GetMapping("/registerCourses")
    public String create (@RequestParam int studentId, Model model) {
        List<RegisterCourse> registerCourses = registerCourseService.findAllByStudent(studentId);

        model.addAttribute("registerCourses", registerCourses);

        // ThymeLeaf 규칙 미정
        return "";
    }
}
