import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class UserRegistrationTest {

    UserRegistration registration = new UserRegistration();

    @Test
    void testValidUserRegistration() {
        String result = registration.registerUser(
                "akash",
                "akash@gmail.com",
                "Password1"
        );
        assertEquals("User registered successfully", result);
    }

    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("ab", "test@gmail.com", "Password1");
        });
    }

    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("akash", "testgmail.com", "Password1");
        });
    }

    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser("akash", "test@gmail.com", "pass");
        });
    }

    @Test
    void testNullInputs() {
        assertThrows(IllegalArgumentException.class, () -> {
            registration.registerUser(null, null, null);
        });
    }
}
