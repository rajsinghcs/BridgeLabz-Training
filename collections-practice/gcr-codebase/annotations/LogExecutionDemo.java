import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
}

class PerformanceTest {

    @LogExecutionTime
    public void fastMethod() throws InterruptedException {
        Thread.sleep(100); 
    }

    @LogExecutionTime
    public void slowMethod() throws InterruptedException {
        Thread.sleep(300); 
    }
}

public class LogExecutionDemo {
    public static void main(String[] args) throws Exception {

        PerformanceTest test = new PerformanceTest();

        Method[] methods = PerformanceTest.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(LogExecutionTime.class)) {

                long startTime = System.nanoTime();
                method.invoke(test);
                long endTime = System.nanoTime();

                long executionTime = endTime - startTime;

                System.out.println(
                    method.getName() + " executed in " + executionTime + " ns"
                );
            }
        }
    }
}

