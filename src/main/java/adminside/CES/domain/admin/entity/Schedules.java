package adminside.CES.domain.admin.entity;

import adminside.CES.domain.course.entity.Course;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
public class Schedules {
    @Id
    private int scheduleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "building_number"),
            @JoinColumn(name = "room_number")
    })
    private ClassRoom classRoom;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course courseId;

    private String classDay;
    private String classStartTime;
    private String classEndTime;
}
