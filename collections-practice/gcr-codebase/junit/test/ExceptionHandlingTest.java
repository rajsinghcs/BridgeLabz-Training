import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
public class ExceptionHandlingTest {
	ExceptionHandling ex = new ExceptionHandling();
	
	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> ex.divide(10, 0));
	}
}
