package adminside.CES.domain.user.service;

import adminside.CES.domain.user.dto.BasketDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService us;

    @Test
    @Transactional
    void createBasketTest(){
        BasketDto dto = new BasketDto();
        dto.setStudentId("201802057");
        dto.setCourseId("23-01");
        boolean bool = us.createBasket(dto);
        Assertions.assertEquals(bool, true);

    }
}
