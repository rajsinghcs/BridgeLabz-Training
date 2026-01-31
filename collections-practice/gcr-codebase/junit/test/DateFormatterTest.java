import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class DateFormatterTest {

    DateFormatter formatter = new DateFormatter();

    @Test
    void testValidDate() {
        assertEquals("30-01-2026",
                formatter.formatDate("2026-01-30"));
    }

    @Test
    void testInvalidDateFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("30-01-2026");
        });
    }

    @Test
    void testInvalidDateValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            formatter.formatDate("2024-99-99");
        });
    }
}
