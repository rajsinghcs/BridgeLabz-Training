import java.util.Scanner;

public class UniqueCharacters {

	// Method 1: Find length without using length()
	static int findLength(String text) {
		int count = 0;
		try {
			while (true) {
				text.charAt(count);
				count++;
			}
		} catch (Exception e) {
			return count;
		}
	}

	// Method 2: Find unique characters using charAt()
	static char[] findUniqueCharacters(String text) {
		int length = findLength(text);

		// Temporary array to store unique characters
		char[] temp = new char[length];
		int index = 0;

		// Outer loop for each character
		for (int i = 0; i < length; i++) {
			char current = text.charAt(i);
			boolean isUnique = true;

			// Inner loop to check previous characters
			for (int j = 0; j < i; j++) {
				if (text.charAt(j) == current) {
					isUnique = false;
					break;
				}
			}

			// Store if unique
			if (isUnique) {
				temp[index] = current;
				index++;
			}
		}

		// Create result array of exact size
		char[] result = new char[index];
		for (int i = 0; i < index; i++) {
			result[i] = temp[i];
		}

		return result;
	}

	// Main method
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter a string: ");
		String text = sc.nextLine();

		char[] uniqueChars = findUniqueCharacters(text);

		System.out.print("Unique characters: ");
		for (char ch : uniqueChars) {
			System.out.print(ch + " ");
		}

		sc.close();
	}
}
