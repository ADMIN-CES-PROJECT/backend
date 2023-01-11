package adminside.CES.domain.course.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    String courseId;
    int targeGrade;
    int credit;
    String name;
    String courseNumber;
    String classNumber;
    String professor;
    int capacity;
    int applicant;
    String major;

}
