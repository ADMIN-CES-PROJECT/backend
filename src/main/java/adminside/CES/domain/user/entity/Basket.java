package adminside.CES.domain.user.entity;

import adminside.CES.domain.user.dto.BasketDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int basketId;

    private String courseId;
    private String studentId;

    private Basket(String courseId, String studentId) {

        this.courseId = courseId;
        this.studentId = studentId;
    }

    public static Basket from(BasketDto dto) {
        return new Basket(dto.getCourseId(), dto.getStudentId());
    }


}
