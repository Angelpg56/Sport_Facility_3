import com.example.sport_facility_3.Controllers.LoginController;
import com.example.sport_facility_3.data.UserFileManagement;
import com.example.sport_facility_3.data.UserRecord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Testing {
    LoginController loginController;

    @Test
    public void testLoginUserCorrect() {
        UserFileManagement.readUsersFromFile();
        loginController = new LoginController();
        assertEquals(1, loginController.Login("Angel","Angel1*"));
    }

    @Test
    public void testLoginUserPassError() {
        UserFileManagement.readUsersFromFile();
        loginController = new LoginController();
        assertEquals(-3, loginController.Login("Angel","Angel1"));
    }

    @Test
    public void testLoginUserUserError() {
        UserFileManagement.readUsersFromFile();
        loginController = new LoginController();
        assertEquals(-2, loginController.Login("Manuel","Angel1*"));
    }

    @Test
    public void testLoginEmpty() {
        UserFileManagement.readUsersFromFile();
        loginController = new LoginController();
        assertEquals(-1, loginController.Login("",""));
    }

    @Test
    public void testRegisterUnExistingUser() {
        UserFileManagement.readUsersFromFile();
        loginController = new LoginController();
        assertEquals(1, loginController.register("Angel2","Angel2*"));
    }

    @Test
    public void testRegisterExistingUser() {
        UserFileManagement.readUsersFromFile();
        loginController = new LoginController();
        assertEquals(-2, loginController.register("Angel","Angel1*"));
    }

    @Test
    public void testRegisterInvalidPass() {
        UserFileManagement.readUsersFromFile();
        loginController = new LoginController();
        assertEquals(-1, loginController.register("Angel1","angel"));
        assertEquals(-1, loginController.register("Angel1","Angel*"));
        assertEquals(-1, loginController.register("Angel1","Angel2"));
        assertEquals(-1, loginController.register("Angel1","angel2*"));
    }
}