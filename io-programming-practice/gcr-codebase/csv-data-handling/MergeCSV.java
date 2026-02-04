import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br1 = new BufferedReader(new FileReader("students1.csv"));
        BufferedReader br2 = new BufferedReader(new FileReader("students2.csv"));
        PrintWriter pw = new PrintWriter("merged.csv");

        Map<String, String> map = new HashMap<>();
        br1.readLine();
        String line;

        while ((line = br1.readLine()) != null) {
            String[] d = line.split(",");
            map.put(d[0], line);
        }

        pw.println("ID,Name,Age,Marks,Grade");
        br2.readLine();
        while ((line = br2.readLine()) != null) {
            String[] d = line.split(",");
            pw.println(map.get(d[0]) + "," + d[1] + "," + d[2]);
        }

        br1.close();
        br2.close();
        pw.close();
    }
}
