package json;

import com.fasterxml.jackson.databind.ObjectMapper;

class Student {
    public String name;
    public int age;
}

public class VaildateJson {
    public static void main(String[] args) {
        String json = "{ \"name\": \"Nived\", \"age\": 22 }";

        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.readValue(json, Student.class);
            System.out.println("JSON structure is valid");
        } catch (Exception e) {
            System.out.println("JSON structure is invalid");
        }
    }
}

