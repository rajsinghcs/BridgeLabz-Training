import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    StringUtils strUtils = new StringUtils();

    @Test
    void testReverse() {
        assertEquals("qwerT", strUtils.reverseString("Trewq"));
    }

    @Test
    void testIsPalindrome() {
        assertFalse(strUtils.isPalindrome("alaska"));
    }

    @Test
    void testToUpperCase() {
        assertEquals("RAJBAHADUR", strUtils.toUpperCase("RajBahadur"));
    }
}
