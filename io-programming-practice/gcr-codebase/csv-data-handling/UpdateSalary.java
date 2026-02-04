import java.io.*;

public class UpdateSalary {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        PrintWriter pw = new PrintWriter(new FileWriter("updated_employees.csv"));
        String line;

        pw.println(br.readLine()); // header
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            if (d[2].equalsIgnoreCase("IT")) {
                double salary = Double.parseDouble(d[3]);
                d[3] = String.valueOf(salary * 1.10);
            }
            pw.println(String.join(",", d));
        }

        br.close();
        pw.close();
    }
}
