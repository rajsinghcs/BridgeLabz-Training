import java.lang.reflect.Constructor;

public class ReflectionObjectCreation {

    static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void display() {
            System.out.println("Name: " + name + ", Age: " + age);
        }
    }

    public static void main(String[] args) throws Exception {

        Class<?> cls = Class.forName("reflection.ReflectionObjectCreation$Student");

        Constructor<?> constructor = cls.getConstructor(String.class, int.class);

        Object obj = constructor.newInstance("Raj", 22);

        Student student = (Student) obj;
        student.display();
    }
}
