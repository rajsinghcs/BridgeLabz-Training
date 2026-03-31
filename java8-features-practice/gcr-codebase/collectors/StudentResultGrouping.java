package collectors;

import java.util.*;
import java.util.stream.Collectors;

public class StudentResultGrouping {

    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("Amit", "A"),
                new Student("Rohit", "B"),
                new Student("Neha", "A"),
                new Student("Pooja", "C")
        );

        Map<String, List<String>> result =
                students.stream()
                        .collect(Collectors.groupingBy(
                                Student::getGrade,
                                Collectors.mapping(Student::getName, Collectors.toList())
                        ));

        System.out.println(result);
    }
}

class Student {
    private String name;
    private String grade;

    public Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() { return name; }
    public String getGrade() { return grade; }
}

