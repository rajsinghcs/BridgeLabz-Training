package streamapi;

import java.util.List;

public class DisplayCustomer {
	public static void main(String args[]) {
		List<String> names = List.of("Tushar","paras","chinmay");
		
		names.stream()
		.map(d -> 
		d.substring(0,1).toUpperCase()+
		d.substring(1).toLowerCase()
		)
		.sorted()
		.forEach(System.out::println);
	}
}
