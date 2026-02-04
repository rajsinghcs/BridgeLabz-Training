package json;

import com.fasterxml.jackson.databind.*;
import java.util.*;

public class ParseJson {
    public static void main(String[] args) throws Exception {

        String json = "[{\"name\":\"Aman\",\"age\":24},{\"name\":\"Nived\",\"age\":26},{\"name\":\"Rohit\",\"age\":30}]";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(json);

        root.forEach(node -> {
            if (node.get("age").asInt() > 25) {
                System.out.println(node);
            }
        });
    }
}

