import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class CustomObjectMapper {

    // Generic method to create an object and set fields from map
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        // Create a new instance of the class
        T obj = clazz.getDeclaredConstructor().newInstance();

        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            String fieldName = entry.getKey();
            Object fieldValue = entry.getValue();

            try {
                Field field = clazz.getDeclaredField(fieldName);

                field.setAccessible(true);

                field.set(obj, fieldValue);

            } catch (NoSuchFieldException e) {
                System.out.println("Field '" + fieldName + "' not found in class " + clazz.getSimpleName());
            }
        }

        return obj;
    }
    
    static class Student {
        private String name;
        private int age;

        public Student() {
        	
        }

        public void display() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Rai");
        map.put("age", 22);
        map.put("nonExistingField", "ignored");

        //map to object
        Student student = toObject(Student.class, map);

        student.display();
    }
}
