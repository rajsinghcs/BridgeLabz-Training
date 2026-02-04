import java.io.*;
import java.util.*;

class Student {
    int id, age, marks;
    String name;
}

public class CSVToObject {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("student.csv"));
        List<Student> list = new ArrayList<>();
        String line;

        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            Student s = new Student();
            s.id = Integer.parseInt(d[0]);
            s.name = d[1];
            s.age = Integer.parseInt(d[2]);
            s.marks = Integer.parseInt(d[3]);
            list.add(s);
        }
        br.close();

        for (Student s : list) {
            System.out.println(s.id + " " + s.name + " " + s.age + " " + s.marks);
        }
    }
}
