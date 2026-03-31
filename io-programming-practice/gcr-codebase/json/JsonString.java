package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public class JsonString {
    public static void main(String args[]) throws Exception {

        String json = "{ \"name\": \"Nived\", \"age\": 21, \"subjects\": [\"Maths\", \"Computer Science\", \"Physics\"] }";

        ObjectMapper ob = new ObjectMapper();

        JsonNode node = ob.readTree(json);

        System.out.println(node.toPrettyString());
    }
}

