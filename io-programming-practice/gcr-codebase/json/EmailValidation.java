package json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.regex.Pattern;

public class EmailValidation {

    public static void main(String[] args) throws Exception {

        String json = """
        [
          { "name": "Aman", "email": "aman@gmail.com" },
          { "name": "Riya", "email": "riya@company.com" },
          { "name": "Rahul", "email": "rahulgmail.com" }
        ]
        """;

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode arrayNode = mapper.readTree(json);

        for (JsonNode node : arrayNode) {
            String name = node.get("name").asText();
            String email = node.get("email").asText();

            if (pattern.matcher(email).matches()) {
                System.out.println(name + " -> valid email");
            } else {
                System.out.println(name + " -> invalid email");
            }
        }
    }
}

