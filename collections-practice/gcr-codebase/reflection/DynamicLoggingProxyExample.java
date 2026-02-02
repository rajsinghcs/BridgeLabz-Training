import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicLoggingProxyExample {

    // Step 1: Define the interface
    interface Greeting {
        void sayHello(String name);
        void sayGoodbye(String name);
    }

    // Step 2: Real implementation of the interface
    static class GreetingImpl implements Greeting {
        @Override
        public void sayHello(String name) {
            System.out.println("Hello, " + name + "!");
        }

        @Override
        public void sayGoodbye(String name) {
            System.out.println("Goodbye, " + name + "!");
        }
    }

    // Step 3: Create a proxy with logging
    @SuppressWarnings("unchecked")
    public static <T> T createLoggingProxy(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class<?>[]{interfaceType},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // Log method name and arguments
                        System.out.print("Method called: " + method.getName());
                        if (args != null && args.length > 0) {
                            System.out.print(" with args: ");
                            for (Object arg : args) {
                                System.out.print(arg + " ");
                            }
                        }
                        System.out.println();

                        // Invoke actual method
                        return method.invoke(target, args);
                    }
                }
        );
    }

    // Step 4: Test the proxy
    public static void main(String[] args) {
        Greeting realGreeting = new GreetingImpl();

        // Wrap the real object with a logging proxy
        Greeting proxyGreeting = createLoggingProxy(realGreeting, Greeting.class);

        // Calls go through the proxy
        proxyGreeting.sayHello("Raj");
        proxyGreeting.sayGoodbye("Raj");
    }
}

