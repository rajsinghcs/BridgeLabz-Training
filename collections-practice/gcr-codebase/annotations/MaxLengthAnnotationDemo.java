import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {

    @MaxLength(10)
    private String username;

    public User(String username) {

        try {
            Field field = this.getClass().getDeclaredField("username");
            MaxLength maxLength = field.getAnnotation(MaxLength.class);

            if (maxLength != null && username.length() > maxLength.value()) {
                throw new IllegalArgumentException(
                    "Username length exceeds " + maxLength.value()
                );
            }

            this.username = username;

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

public class MaxLengthAnnotationDemo {
    public static void main(String[] args) {

        User user1 = new User("Raj123");    
        System.out.println(user1.getUsername());

        User user2 = new User("VeryLongUsername");
    }
}
