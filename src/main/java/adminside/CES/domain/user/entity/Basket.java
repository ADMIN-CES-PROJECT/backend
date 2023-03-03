package adminside.CES.domain.user.entity;

import adminside.CES.domain.course.entity.Course;
import adminside.CES.domain.user.dto.BasketDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int basketId;
    @ManyToOne
    @JoinColumn(name = "courseId")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    private Basket(Course course, Student student) {

        this.course = course;
        this.student = student;
    }

    public static Basket from(Course course, Student student) {
        return new Basket(course, student);
    }


}
