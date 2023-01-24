package adminside.CES.domain.admin.entity;

import adminside.CES.domain.course.entity.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class Schedule {
    @Id
    private int schuduleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classrommId")
    private ClassRoom classRoom;

//    @ManyToOne
//    @JoinColumn(name = "building_number")
//    private ClassRoom buildingNumber;
//
//    @ManyToOne
//    @JoinColumn(name = "romm_number")
//    private ClassRoom roomNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course courseId;

    private String classDay;
    private String classStartTime;
    private String classEndTime;
}
