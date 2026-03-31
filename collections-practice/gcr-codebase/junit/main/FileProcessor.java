import java.io.*;

public class FileProcessor {

    public void writeToFile(String filename, String content) throws IOException {
        FileWriter writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }

    public String readFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        StringBuilder content = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            content.append(line);
        }
        reader.close();

        return content.toString();
    }
}
