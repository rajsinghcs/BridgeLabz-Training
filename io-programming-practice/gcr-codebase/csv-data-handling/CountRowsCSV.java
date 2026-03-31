import java.io.*;

public class CountRowsCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("student.csv"));
        int count = 0;

        br.readLine(); // skip header
        while (br.readLine() != null) {
            count++;
        }

        System.out.println("Total Records: " + count);
        br.close();
    }
}
