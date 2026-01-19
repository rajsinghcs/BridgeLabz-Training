
public class Contact {
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	int zip;
	String phoneNumber;
	String email;

	Contact(String firstName, String lastName, String address, String city, String state, int zip, String phoneNumber,String email) {
        this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.zip = zip;
	}

	public String toString() {
		return "Name : "+this.firstName + " " + this.lastName + "\n" +"Address : "+ this.address + ", " + this.city + ", " + this.state + ", "
				+ this.zip + "\n" + "Conatct : +91 "+ this.phoneNumber + "\n" + "Email : "+this.email + "\n";
	}

}