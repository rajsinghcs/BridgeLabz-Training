import java.lang.reflect.Method;
public class MeasureExecutionTime {

    static class MathOperations {
        public void addNumbers() {
            int sum = 0;
            for (int i = 1; i <= 1000000; i++) {
                sum += i;
            }
        }

        public void multiplyNumbers() {
            long product = 1;
            for (int i = 1; i <= 1000; i++) {
                product *= i;
            }
        }
    }

    public static void measureExecutionTime(Object obj) throws Exception {
        Class<?> clazz = obj.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            method.setAccessible(true);

            long startTime = System.nanoTime();
            
            method.invoke(obj);

            long endTime = System.nanoTime();

            long duration = endTime - startTime;
            System.out.println("Method: " + method.getName() + " executed in " + duration + " ns");
        }
    }

    public static void main(String[] args) throws Exception {
        MathOperations mathOps = new MathOperations();

        measureExecutionTime(mathOps);
    }
}
