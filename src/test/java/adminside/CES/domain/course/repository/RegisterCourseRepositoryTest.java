package adminside.CES.domain.course.repository;

import adminside.CES.domain.course.entity.Course;
import adminside.CES.domain.course.entity.RegisterCourse;
import adminside.CES.domain.user.entity.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class RegisterCourseRepositoryTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    RegisterCourseRepository registerCourseRepository;

    @Test
    void 수강신청 () {
        // 실제로는 find~ 를 통해 해당 데이터를 찾고 기입해야 함

    }

    @Test
    void 수강신청목록조회 () {
        Student student = new Student();
        student.setId(201702018);

        Course course = new Course();
        course.setCourseId("test1");
        
        RegisterCourse rc = new RegisterCourse();
        rc.setRegisterCourse(student, course);
        //현재 과목 및 학생 CRUD 미구현 -> 추후 구현 이후 실제 DB 에서 확인 예정
        em.persist(student);
        em.persist(course);
        //---------------------------
        registerCourseRepository.save(rc);

        RegisterCourse findRcs = registerCourseRepository.findAllByStudent(student).get(0);
        RegisterCourse findRcc = registerCourseRepository.findAllByCourse(course).get(0);

        Assertions.assertThat(findRcs).isEqualTo(rc);
        Assertions.assertThat(findRcc).isEqualTo(rc);

    }
}