import java.io.*;

public class WriteUserInputToFile {
    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            FileWriter fw = new FileWriter("output.txt", true);

            String input;
            System.out.println("Enter text (type 'exit' to stop):");

            while (!(input = br.readLine()).equalsIgnoreCase("exit")) {
                fw.write(input + "\n");
            }

            fw.close();
            br.close();
            isr.close();

            System.out.println("Data written to file successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
