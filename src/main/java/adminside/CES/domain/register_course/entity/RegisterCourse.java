package adminside.CES.domain.register_course.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class RegisterCourse {

    @Id
    @GeneratedValue
    private Long id;

    public String course_id;
    public String student_id;
}
