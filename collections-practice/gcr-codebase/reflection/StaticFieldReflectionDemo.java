import java.lang.reflect.Field;

class Configuration {

    private static String API_KEY = "OLD_KEY";

    public static void printKey() {
        System.out.println("API_KEY = " + API_KEY);
    }
}

public class StaticFieldReflectionDemo {

    public static void main(String[] args) throws Exception {

        Class<?> cls = Configuration.class;

        Field field = cls.getDeclaredField("API_KEY");
        field.setAccessible(true);

        field.set(null, "NEW_SECRET_KEY");

        Configuration.printKey();
    }
}
