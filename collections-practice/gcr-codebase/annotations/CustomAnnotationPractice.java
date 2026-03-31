import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";  
}

class ProjectTasks {

    @ImportantMethod
    public void deployApp() {
        System.out.println("App deployed");
    }

    @ImportantMethod(level = "MEDIUM")
    public void testApp() {
        System.out.println("App tested");
    }

    public void documentation() {
        System.out.println("Documentation completed");
    }
}

public class CustomAnnotationPractice {
    public static void main(String[] args) {

        Method[] methods = ProjectTasks.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Level: " + annotation.level());
            }
        }
    }
}
