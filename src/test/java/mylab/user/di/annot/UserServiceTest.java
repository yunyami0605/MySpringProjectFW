package mylab.user.di.annot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.ContextConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
class UserServiceTest {

    @Autowired
    private UserService userService;


    @Test
    @DisplayName("UserService의 레퍼런스가 Not Null 인지 검증")
    void UserServiceNotNullCheck() {
        Assertions.assertNotNull(userService);
    }
    
    @Test
    @DisplayName("userService.getUserRepository() 가 Not Null 인지 검증")
    void UserRepositoryNotNullCheck() {
        Assertions.assertNotNull(userService.getUserRepository());
    }

    @Test
    @DisplayName("userService.getUserRepository().getDbType() 값이 MySQL 인지 값을 비교하기")
    void UserRepositoryInjectionAndDBCheck() {
        Assertions.assertEquals("Maria", userService.getUserRepository().getDbType());
    }

    @Test
    @DisplayName("userService.getSecurityService() 가 Not Null 인지 검증")
    void UserServiceInjectionCheck() {
        Assertions.assertNotNull(userService.getSecurityService());
    }

    @Test
    @DisplayName("userService.registerUser() 메서드가 True 인 검증")
    void RegisterUserReturnTrue() {
        Assertions.assertTrue(userService.registerUser("id14435", "test1", "test1234"));
    }
}