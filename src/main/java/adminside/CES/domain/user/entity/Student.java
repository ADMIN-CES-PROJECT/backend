package adminside.CES.domain.user.entity;

import adminside.CES.domain.course.entity.RegisterCourse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
    private List<RegisterCourse> registerCourses = new ArrayList<>();

    public void setId(int id) {
        this.id = id;
    }
}