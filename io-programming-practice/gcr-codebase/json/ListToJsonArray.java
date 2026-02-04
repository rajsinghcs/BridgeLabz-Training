package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;
class 	Person {
    public int id;
    public String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class ListToJsonArray {
    public static void main(String[] args) throws Exception {

        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "Nived"));
        list.add(new Person(2, "Aman"));

        ObjectMapper mapper = new ObjectMapper();

        String jsonArray = mapper.writeValueAsString(list);

        System.out.println(jsonArray);
    }
}

