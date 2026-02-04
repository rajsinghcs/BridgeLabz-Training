package json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ReadJson {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("C:/Users/91707/Documents/student.json");
        if (!file.exists()) {
            System.out.println("File not found! Check the path.");
            return;
        }

        try {
            JsonNode rootNode = mapper.readTree(file);
            if (rootNode.isArray()) {
                for (JsonNode studentNode : rootNode) {
                    String name = studentNode.get("name").asText();
                    String email = studentNode.get("email").asText();
                    System.out.println("Name: " + name + ", Email: " + email);
                }
            } else {
                System.out.println("JSON is not an array!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
