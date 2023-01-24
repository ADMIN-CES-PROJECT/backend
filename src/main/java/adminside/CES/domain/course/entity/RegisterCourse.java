package adminside.CES.domain.course.entity;

import adminside.CES.domain.user.entity.Student;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class RegisterCourse {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
}
