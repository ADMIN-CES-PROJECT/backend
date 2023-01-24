package adminside.CES.domain.user.entity;

import adminside.CES.domain.course.entity.RegisterCourse;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Student {

    @Id
    @Column(name = "student_id")
    private int id;

    private String email;

    private String password;

    private String name;

    private int grade;

    private int credits;

    private String major;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<RegisterCourse> registerCourses;
}
