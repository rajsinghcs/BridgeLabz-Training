import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

class Software {

    @BugReport(description = "Login error")
    @BugReport(description = "UI issue")
    public void login() {
        System.out.println("Login running");
    }
}

public class RepeatableAnnotationDemo {
    public static void main(String[] args) throws Exception {
        Method method = Software.class.getMethod("login");

        // Get all repeatable annotations
        BugReport[] bugs = method.getAnnotationsByType(BugReport.class);

        for (BugReport bug : bugs) {
            System.out.println("Bug: " + bug.description());
        }
    }
}
