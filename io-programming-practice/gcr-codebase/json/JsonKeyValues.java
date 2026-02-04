package json;
import com.fasterxml.jackson.databind.*;
import java.io.File;

public class JsonKeyValues {
    public static void main(String[] args) throws Exception{

    	ObjectMapper mapper = new ObjectMapper();
    	JsonNode root = mapper.readTree(new File("C:/Users/91707/Documents/student.json"));

    	if (root.isObject()) {
    	    root.fields().forEachRemaining(e ->
    	            System.out.println(e.getKey() + " : " + e.getValue())
    	    );
    	} else if (root.isArray()) {
    	    root.forEach(node ->
    	            node.fields().forEachRemaining(e ->
    	                    System.out.println(e.getKey() + " : " + e.getValue())
    	            )
    	    );
    	}

    }
}

