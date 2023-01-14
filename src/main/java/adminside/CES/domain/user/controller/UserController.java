package adminside.CES.domain.user.controller;


import adminside.CES.domain.course.entity.Course;
import adminside.CES.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/basket")
    public ResponseEntity<List<Course>> getBasket(@RequestParam String userId) {
        return ResponseEntity.ok(userService.getBasket(userId));
    }
}
