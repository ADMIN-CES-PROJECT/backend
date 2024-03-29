package adminside.CES.domain.user.repository;

import adminside.CES.domain.user.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Student, Integer> {
}
