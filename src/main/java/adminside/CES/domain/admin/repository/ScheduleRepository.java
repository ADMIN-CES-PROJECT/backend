package adminside.CES.domain.admin.repository;

import adminside.CES.domain.admin.entity.Schedules;
import adminside.CES.domain.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedules, Integer> {

    @Query("select s from Schedules s where s.courseId.courseId =:courseId")
    Optional<List<Schedules>> findByCourseId(@Param("courseId") String courseId);
}
