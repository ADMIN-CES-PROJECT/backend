package adminside.CES.domain.user.dto;

import adminside.CES.domain.course.entity.Course;
import adminside.CES.domain.user.entity.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasketDto {
    private String courseId;
    private int studentId;
}
