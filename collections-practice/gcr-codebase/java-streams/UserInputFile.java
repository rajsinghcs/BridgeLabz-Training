import java.io.*;

public class UserInputFile {
    public static void main(String[] args) {
        BufferedReader br = null;
        FileWriter fw = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter your name: ");
            String name = br.readLine();

            System.out.print("Enter your age: ");
            String age = br.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();

            fw = new FileWriter("user_details.txt");

            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Favorite Language: " + language + "\n");

            System.out.println("Data saved successfully");

        } catch (IOException e) {
            System.out.println("Error occurred");

        } finally {
            try {
                if (br != null) br.close();
                if (fw != null) fw.close();
            } catch (IOException e) {
                System.out.println("Error closing resources");
            }
        }
    }
}
