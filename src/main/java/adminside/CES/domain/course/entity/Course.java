package adminside.CES.domain.course.entity;


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
@Table(name = "courses")
public class Course {
    @Id
    String courseId;
    int targetGrade;
    int credit;
    String name;
    String courseNumber;
    String classNumber;
    String professor;
    int capacity;
    int applicant;
    String major;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<RegisterCourse> registerCourses = new ArrayList<>();

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
}