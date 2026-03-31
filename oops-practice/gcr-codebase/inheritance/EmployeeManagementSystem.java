class Employees{
    String name;
    int id;
    int salary;

    Employees(String name, int id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
}
class Manager extends Employees{
    int teamSize;

    Manager(String name, int id, int salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }
}
class Developer extends Employees{
    String programmingLanguage;

    Developer(String name, int id, int salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }
}
class Intern extends Employees{
    public Intern(String name, int id, int salary) {
        super(name, id, salary);
    }
}
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employees e = new Employees("John", 1, 1000);
        System.out.println("Employee: " + e.name + ", ID: " + e.id + ", Salary: " + e.salary);
        Manager m = new Manager("John", 1, 1000, 10);
        System.out.println("Manager: " + m.name + ", ID: " + m.id + ", Salary: " + m.salary + ", Team Size: " + m.teamSize);
        Developer d = new Developer("John", 1, 1000, "Java");
        System.out.println("Developer: " + d.name + ", ID: " + d.id + ", Salary: " + d.salary + ", Programming Language: " + d.programmingLanguage);
        Intern i = new Intern("John", 1, 1000);
        System.out.println("Intern: " + i.name + ", ID: " + i.id + ", Salary: " + i.salary);
    }
}   