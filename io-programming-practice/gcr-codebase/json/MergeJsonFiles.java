package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;

public class MergeJsonFiles {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode json1 = mapper.readTree(new File("C:/Users/91707/Documents/student.json"));
        JsonNode json2 = mapper.readTree(new File("C:/Users/91707/Documents/student2.json"));

        ObjectNode merged = mapper.createObjectNode();

        merged.setAll((ObjectNode) json1);
        merged.setAll((ObjectNode) json2);

        System.out.println(mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(merged));
    }
}

