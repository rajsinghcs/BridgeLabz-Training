import java.util.*;

public class AddressBook {
	private ArrayList<Contact> addressBook;

	AddressBook() {
		addressBook = new ArrayList<>();
	}

	protected void addNewContact(Contact newContact) {
		if (newContact != null)
			addressBook.add(newContact);
	}

	protected void display() {
		for (Contact c : addressBook) {
			System.out.print(c);
		}
	}

	private boolean isContactAvailable(String firstName) {
		for (Contact c : addressBook) {
			if (c.firstName.equals(firstName)) {
				return true;
			}
		}
		return false;

	}

	private Contact getContactWithName(String firstName) {
		Contact toReturn = null;
		for (Contact c : addressBook) {
			if (c.firstName.equals(firstName)) {
				toReturn = c;
				break;
			}
		}
		return toReturn;
	}

	protected void editContact() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the first name of person You want to edit ");
		String name = sc.next();
		boolean isContactAvailable = isContactAvailable(name);
		if (!isContactAvailable) {
			System.out.println("No contact with first name " + name + " present in the address Book");
		} else {
			Contact c = getContactWithName(name);
			System.out.println("Enter new first Name : ");
			c.firstName = sc.next();
			System.out.println("Enter new last Name : ");
			c.lastName = sc.next();
			System.out.println("Enter new Address : ");
			c.address = sc.next();
			System.out.println("Enter new city : ");
			c.city = sc.next();
			System.out.println("Enter new state : ");
			c.state = sc.next();
			System.out.println("Enter new zip : ");
			c.zip = sc.nextInt();
			System.out.println("Enter new phone number : ");
			c.phoneNumber = sc.next();
			System.out.println("Enter new email : ");
			c.email = sc.next();
			sc.close();
		}
	}
	
}