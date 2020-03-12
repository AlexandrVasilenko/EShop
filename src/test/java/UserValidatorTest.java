import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import ru.alx.javaproject.eshop.entity.User;
import ru.alx.javaproject.eshop.service.UserService;
import ru.alx.javaproject.eshop.service.UserValidator;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


@SpringBootTest
public class UserValidatorTest {

    @Mock
    private UserService userService;

    @InjectMocks
    UserValidator userValidator;

    private User existedUser;
    private User nonExistedUser;
    private User userWrongPassword;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        existedUser = new User("TestName","Password");
        nonExistedUser = new User("NonExistedName","Password123");
        userWrongPassword = new User ("UserWrongPassword", "12345");

        when(userService.findByLogin("TestName")).thenReturn(existedUser);
        when(userService.findByLogin("UserWrongPassword")).thenReturn(existedUser);
        when(userService.findByLogin("NonExistedName")).thenThrow(EmptyResultDataAccessException.class);

    }

    @Test
    public void testCheckUserAuthorization(){
        assertTrue(userValidator.checkUserAuthorization(existedUser));
        assertFalse(userValidator.checkUserAuthorization(userWrongPassword));
    }

    @Test
    public void testCheckUserExistence(){
        assertTrue(userValidator.checkUserExistence(existedUser));
        assertFalse(userValidator.checkUserExistence(nonExistedUser));
    }


}
