package adminside.CES.domain.user.repository;

import adminside.CES.domain.user.entity.Basket;
import adminside.CES.domain.user.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer> {

    Optional<List<Basket>> findByStudentId(int studentId);
}
