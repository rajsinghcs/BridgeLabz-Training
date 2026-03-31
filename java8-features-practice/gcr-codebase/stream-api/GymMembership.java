package streamapi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

class Details{
	String name;
	String expiryDate;
	
	public Details(String name, String expiryDate) {
		this.name = name;
		this.expiryDate = expiryDate;
	}
}
public class GymMembership {
	public static void main(String args[]) {
		List<Details> list = List.of(
				new Details("Tushar","03-03-2026"),
				new Details("Paras","10-02-2026"),
				new Details("Chinmay","07-03-2026")
				);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date = LocalDate.now();
		list.stream()
				.filter(a -> {
					LocalDate expiry =LocalDate.parse(a.expiryDate,formatter);
					long gap = ChronoUnit.DAYS.between(date,expiry);
					
					return gap >= 30;
				})
				.forEach(a -> System.out.println(a.name));
	}
}
