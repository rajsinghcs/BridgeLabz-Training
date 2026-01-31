import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class LongRunningTaskTest {
	LongRunningTask task= new LongRunningTask();
	
	@Test
	@Timeout(2)
	void testLongRunningTask() throws InterruptedException{
		task.longRunningTask();
	}
}
