public class AddressBookMain {

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		Contact c = new Contact("Raj Bahadur", "Singh", "Omaxe City", "Agra", "UP", 28311, "9588847449","raj@gmail.com");
		AddressBook book = new AddressBook();
		book.addNewContact(c);
		book.display();
		book.editContact();
		book.display();
	}
}