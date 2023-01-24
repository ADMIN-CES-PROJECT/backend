package adminside.CES.domain.admin.repository;

import adminside.CES.domain.admin.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integers> {
}
