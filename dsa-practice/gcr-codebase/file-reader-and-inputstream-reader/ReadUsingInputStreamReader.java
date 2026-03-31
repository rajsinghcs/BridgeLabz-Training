import java.io.*;

public class ReadUsingInputStreamReader {
    public static void main(String[] args) {
        try (
            FileInputStream fis = new FileInputStream("input.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
