class Person{
    String name;
    int age;
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}
class Student extends Person{
    String grade;
    Student(String name, int age, String grade){
        super(name, age);
        this.grade = grade;
    }
    void displayInfo(){
        System.out.println("Name: " + name + ", Age: " + age + ", Grade: " + grade);
    }
}
class Teacher extends Person{
    String subject;
    Teacher(String name, int age, String subject){
        super(name, age);
        this.subject = subject;
    }
    void displayInfo(){
        System.out.println("Name: " + name + ", Age: " + age + ", Subject: " + subject);
    }   
}
class Staff extends Person {
    String position;

    Staff(String name, int age, String position) {
        super(name, age);
        this.position = position;
    }

    void displayRole() {
        System.out.println(name + " is a Staff member: " + position);
    }
}
public class SchoolSystemHeirarchical {
    public static void main(String[] args) {
        Student s = new Student("John", 12, "A");
        s.displayInfo();
        Teacher t = new Teacher("Jane", 30, "Math");
        t.displayInfo();
        Staff st = new Staff("Jack", 40, "Principal");
        st.displayRole();
    }
}
