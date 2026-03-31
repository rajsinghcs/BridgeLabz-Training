import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenCheckTest {

    EvenCheck evenCheck = new EvenCheck();

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 7, 9})
    void testIsEven(int num) {

        if (num % 2 == 0) {
            assertTrue(evenCheck.isEven(num));
        } else {
            assertFalse(evenCheck.isEven(num));
        }
    }
}
