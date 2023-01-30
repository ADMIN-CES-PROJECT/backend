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

    public RegisterCourse(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public void setRegisterCourse(Student student, Course course){
        this.student = student;
        this.course = course;
        student.getRegisterCourses().add(this);
        course.getRegisterCourses().add(this);
    }
}
