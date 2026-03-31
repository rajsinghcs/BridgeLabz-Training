import java.lang.reflect.Field;

class JsonUtil {

 public static String toJson(Object obj) throws IllegalAccessException {
     if (obj == null) {
         return "null";
     }

     StringBuilder json = new StringBuilder("{");

     Field[] fields = obj.getClass().getDeclaredFields();
     for (int i = 0; i < fields.length; i++) {
         Field field = fields[i];
         field.setAccessible(true);

         json.append("\"").append(field.getName()).append("\":");

         Object value = field.get(obj);

         if (value instanceof String) {
             json.append("\"").append(value).append("\"");
         } else {
             json.append(value);
         }

         if (i < fields.length - 1) {
             json.append(", ");
         }
     }

     json.append("}");
     return json.toString();
 }
}

class User {
 public String name;
 public int age;
}

public class ObjectToJson {
 public static void main(String[] args) throws Exception {
     User u = new User();
     u.name = "Raj";
     u.age = 22;

     String json = JsonUtil.toJson(u);
     System.out.println(json);
 }
}
