package streamapi;
import java.util.List;
public class WelcomeMessage {
	    public static void main(String[] args) {

	        List<String> names = List.of(
	                "Tushar",
	                "Paras",
	                "Chinmay",
	                "Raman"
	        );

	        names.forEach(n ->
	                System.out.println("Welcome " + n)
	        );
	    }
}
