import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("student.csv"));
        Pattern email = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Pattern phone = Pattern.compile("\\d{10}");
        String line;

        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            if (!email.matcher(d[4]).matches() || !phone.matcher(d[5]).matches()) {
                System.out.println("Invalid Row: " + line);
            }
        }
        br.close();
    }
}
