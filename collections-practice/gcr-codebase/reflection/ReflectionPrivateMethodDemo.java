import java.lang.reflect.Method;

public class ReflectionPrivateMethodDemo {

	static class Calculator {

		private int multiply(int a, int b) {
			return a * b;
		}
	}

	public static void main(String[] args) throws Exception {

		Calculator calc = new Calculator();
		Class<?> cls = calc.getClass();

		Method method = cls.getDeclaredMethod("multiply", int.class, int.class);
		method.setAccessible(true);

		Object result = method.invoke(calc, 5, 4);
		System.out.println("Result: " + result);
	}
}
