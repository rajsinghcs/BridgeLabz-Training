package streamapi;

import java.util.Comparator;
import java.util.List;

class Doctor{
	String name;
	boolean availability;
	String speciality;
	public Doctor(String name, boolean availability, String speciality) {
		this.name = name;
		this.availability = availability;
		this.speciality = speciality;
	}
	
	
}
public class DoctorAvailability {
	public static void main(String args[]) {
		List<Doctor> list = List.of(
				new Doctor("Tushar",true,"Cardiologist"),
				new Doctor("Hana",true,"Physcian"),
				new Doctor("Ken",false,"Dermalogist"),
				new Doctor("Paras",true,"Cardiologist"),
				new Doctor("Aman",false,"eye spacialist")
				);
		list.stream()
				.filter(a -> a.availability==true)
				.sorted(Comparator.comparing(d -> d.speciality)) 
				.forEach(d -> System.out.println(d.name));
	}

}
