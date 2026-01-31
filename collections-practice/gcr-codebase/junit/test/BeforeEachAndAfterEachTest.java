import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;

public class BeforeEachAndAfterEachTest {

    BeforeEachAndAfterEach beforeAndAfterEach = new BeforeEachAndAfterEach();

    @BeforeEach
    void testConnect() {
        beforeAndAfterEach.connect();
        assertTrue(beforeAndAfterEach.isConnected(),"Connection should be established before each test");
    }

    @AfterEach
    void testDisconnect() {
        beforeAndAfterEach.disconnect();
        assertFalse(beforeAndAfterEach.isConnected(),"Connection should be closed after each test");
    }

    @Test
    void isConnected() {
        assertTrue(beforeAndAfterEach.isConnected(),"Connection must be active during test execution");
    }
}
