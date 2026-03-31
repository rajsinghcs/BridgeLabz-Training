import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();             
    String assignedTo();    
    String priority() default "MEDIUM"; 
}

class ProjectModule {

    @Todo(task = "Implement login", assignedTo = "Aman", priority = "HIGH")
    public void loginFeature() {
    }

    @Todo(task = "Add payment gateway", assignedTo = "Rohit")
    public void paymentFeature() {
    }

    @Todo(task = "Improve UI design", assignedTo = "Neha", priority = "LOW")
    public void uiUpdate() {
    }
}

public class TodoAnnotationDemo {
    public static void main(String[] args) {

        Method[] methods = ProjectModule.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {

                Todo todo = method.getAnnotation(Todo.class);

                System.out.println("Method: " + method.getName());
                System.out.println(" Task: " + todo.task());
                System.out.println(" Assigned To: " + todo.assignedTo());
                System.out.println(" Priority: " + todo.priority());
                System.out.println();
            }
        }
    }
}

