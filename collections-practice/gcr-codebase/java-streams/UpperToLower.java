import java.io.*;

public class UpperToLower {
    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), "UTF-8"));

            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), "UTF-8"));

            int ch;
            while ((ch = br.read()) != -1) {
                bw.write(Character.toLowerCase((char) ch));
            }

            System.out.println("File converted successfully");

        } catch (IOException e) {
            System.out.println("IO Error occurred");

        } finally {
            try {
                if (br != null) br.close();
                if (bw != null) bw.close();
            } catch (IOException e) {
                System.out.println("Error closing files");
            }
        }
    }
}
