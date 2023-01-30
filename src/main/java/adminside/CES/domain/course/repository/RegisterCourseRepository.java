package adminside.CES.domain.course.repository;

import adminside.CES.domain.course.dto.RegisterCourseRequest;
import adminside.CES.domain.course.entity.RegisterCourse;
import adminside.CES.domain.user.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class RegisterCourseRepository {

    private final EntityManager em;

    public void save(RegisterCourse rc) {
        em.persist(rc);
    }

    public List<RegisterCourse> findAllByStudent(Student student) {
        return em.createQuery("select r from RegisterCourse r where r.student = :student", RegisterCourse.class)
                .setParameter("student", student)
                .getResultList();
    }
}
