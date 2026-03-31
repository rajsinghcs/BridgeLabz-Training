package streamapi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Policy{
	String name;
	int amount;
	
	public Policy(String name,int amount) {
		this.name = name;
		this .amount = amount;
	}
}
public class InsuranceClaim {
	public static void main(String args[]) {
	List<Policy> policies = List.of(
			new Policy("Yojna",2500),
			new Policy("Jeevan jyoti",500),
			new Policy("Yojna",3500),
			new Policy("Yojna",8500),
			new Policy("Yojna",1000),
			new Policy("Jeevan jyoti",500)
			);
	Map<String, Double> avg = 
	 policies.stream()
	 .collect(Collectors.groupingBy(
			 d -> d.name,
			 Collectors.averagingDouble(c -> c.amount)
			 ));
	avg.forEach((name,avgc) ->
			System.out.println(name+" "+avgc)
			);
	}
}
