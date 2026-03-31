import java.io.*;
import java.util.*;

public class LargeCSVReader {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("large.csv"));
        int count = 0;
        List<String> chunk = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {
            chunk.add(line);
            if (chunk.size() == 100) {
                count += chunk.size();
                System.out.println("Processed: " + count);
                chunk.clear();
            }
        }
        br.close();
    }
}
