import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();  
}

class UserData {

    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    private String password; 

    public UserData(String username, int age, String password) {
        this.username = username;
        this.age = age;
        this.password = password;
    }
}

class JsonSerializer {

    public static String toJson(Object obj) throws IllegalAccessException {

        StringBuilder json = new StringBuilder("{");

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {

                field.setAccessible(true);
                JsonField annotation = field.getAnnotation(JsonField.class);

                json.append("\"")
                    .append(annotation.name())
                    .append("\":\"")
                    .append(field.get(obj))
                    .append("\",");
            }
        }

        json.deleteCharAt(json.length() - 1);
        json.append("}");

        return json.toString();
    }
}

public class JsonFieldDemo {
    public static void main(String[] args) throws Exception {

        UserData user = new UserData("Raj", 22, "secret123");

        String json = JsonSerializer.toJson(user);

        System.out.println(json);
    }
}
