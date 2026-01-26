import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println(id + " " + name + " " + department + " " + salary);
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Raj", "IT", 50000));
        employees.add(new Employee(2, "Rohit", "HR", 45000));
        employees.add(new Employee(3, "Nived", "Finance", 60000));

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"));
            oos.writeObject(employees);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.dat"));
            List<Employee> empList = (List<Employee>) ois.readObject();
            ois.close();

            for (Employee e : empList) {
                e.display();
            }

        } catch (IOException e) {
            System.out.println("IO Error");

        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
    }
}
