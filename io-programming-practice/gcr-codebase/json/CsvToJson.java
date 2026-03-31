package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedReader;
import java.io.FileReader;

public class CsvToJson {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        ArrayNode array = mapper.createArrayNode();

        BufferedReader br = new BufferedReader(new FileReader("C://Users//91707//Documents//students.csv"));
        String[] headers = br.readLine().split(",");

        String line;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            ObjectNode obj = mapper.createObjectNode();

            for (int i = 0; i < headers.length; i++) {
                obj.put(headers[i], values[i]);
            }
            array.add(obj);
        }

        br.close();

        System.out.println(
            mapper.writerWithDefaultPrettyPrinter().writeValueAsString(array)
        );
    }
}

