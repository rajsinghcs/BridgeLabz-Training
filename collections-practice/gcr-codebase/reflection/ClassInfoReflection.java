import java.util.*;
import java.lang.reflect.*;

public class ClassInfoReflection {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter class name: ");
        String className = sc.nextLine();

        try {
            // Load class dynamically
            Class<?> cls = Class.forName(className);

            System.out.println("\nClass Name: " + cls.getName());

            // 🔹 Fields
            System.out.println("\nFields:");
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            // 🔹 Constructors
            System.out.println("\nConstructors:");
            Constructor<?>[] constructors = cls.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            // 🔹 Methods
            System.out.println("\nMethods:");
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found!");
        }
    }
}

