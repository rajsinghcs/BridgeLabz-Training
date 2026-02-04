import java.io.*;

public class FilterStudents {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("student.csv"));
        String line;

        br.readLine(); // header
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (Integer.parseInt(data[3]) > 80) {
                System.out.println(line);
            }
        }
        br.close();
    }
}
