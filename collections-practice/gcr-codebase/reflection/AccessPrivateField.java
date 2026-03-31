import java.lang.reflect.Field;

class Person {
    private int age = 25;
}

public class AccessPrivateField {
    public static void main(String[] args) throws Exception {

        Person person = new Person();

        Class<?> cls = person.getClass();
        Field field = cls.getDeclaredField("age");
        field.setAccessible(true);   

        System.out.println("Original Age: " + field.get(person));

        field.set(person, 30);

        System.out.println("Updated Age: " + field.get(person));
    }
}
