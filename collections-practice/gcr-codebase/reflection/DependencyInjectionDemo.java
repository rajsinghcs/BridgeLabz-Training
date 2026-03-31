import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

public class DependencyInjectionDemo {

    @Retention(RetentionPolicy.RUNTIME)
    @interface Inject {
    }

    static class MessageService {
        public void sendMessage(String message) {
            System.out.println("Sending message: " + message);
        }
    }

    static class UserController {
        @Inject
        private MessageService messageService; // dependency to inject

        public void process() {
            messageService.sendMessage("Hello from UserController!");
        }
    }

    // Step 4: Simple DI Container
    static class SimpleDIContainer {
        public static <T> T getInstance(Class<T> clazz) throws Exception {
            // Create an instance of the class
            T obj = clazz.getDeclaredConstructor().newInstance();

            // Scan fields for @Inject
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    field.setAccessible(true);

                    // Recursively create and inject dependency
                    Object dependency = getInstance(field.getType());
                    field.set(obj, dependency);
                }
            }
            return obj;
        }
    }

    public static void main(String[] args) throws Exception {
        // Get UserController instance with dependencies injected
        UserController controller = SimpleDIContainer.getInstance(UserController.class);

        // Call method; dependency should be injected automatically
        controller.process();
    }
}
