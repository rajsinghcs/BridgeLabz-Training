import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();  
}

class AdminService {

    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted successfully");
    }

    public void viewUser() {
        System.out.println("Viewing user details");
    }
}

class UserContext {
    static String currentRole = "USER"; 
}

public class RoleBasedAccessDemo {
    public static void main(String[] args) throws Exception {

        AdminService service = new AdminService();
        Method[] methods = AdminService.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(RoleAllowed.class)) {

                RoleAllowed roleAllowed = method.getAnnotation(RoleAllowed.class);

                if (UserContext.currentRole.equals(roleAllowed.value())) {
                    method.invoke(service);
                } else {
                    System.out.println("Access Denied!");
                }

            } else {
                method.invoke(service);
            }
        }
    }
}
