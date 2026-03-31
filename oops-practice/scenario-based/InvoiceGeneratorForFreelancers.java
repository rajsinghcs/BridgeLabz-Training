import java.util.*;

public class InvoiceGeneratorForFreelancers {
	public static String[] parseInvoice(String input) {
		if (!input.contains("-")) {
			throw new InvalidInvoiceFormatException("Missing '-' in invoice input");
		}
		String[] tasks = input.split(",");
		for (String s : tasks) {
			if (!s.contains("-")) {
				throw new InvalidInvoiceFormatException("Invalid task format: " + s.trim());
			}
		}
		return tasks;
	}

	public static int getTotalAmount(String[] tasks) {
		int total = 0;

		for (String s : tasks) {
			String[] parts = s.split("-");
			if (parts.length < 2) {
				throw new InvalidInvoiceFormatException("Amount missing in task");
			}
			String amountPart = parts[1].replaceAll("[^0-9]", "");
			if (amountPart.isEmpty()) {
				throw new InvalidInvoiceFormatException("Invalid amount in task: " + s.trim());
			}
			total += Integer.parseInt(amountPart);
		}
		return total;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter input like: Logo Design - 3000 INR, Web Page - 4500 INR");
		String input = sc.nextLine();
		try {
			String[] tasks = parseInvoice(input);
			int totalAmount = getTotalAmount(tasks);

			System.out.println("Invoice Details:");
			for (String task : tasks) {
				System.out.println(task.trim());
			}
			System.out.println("Total Amount: " + totalAmount + " INR");

		} catch (InvalidInvoiceFormatException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}

class InvalidInvoiceFormatException extends RuntimeException {
	public InvalidInvoiceFormatException(String message) {
		super(message);
	}
}
