import java.util.Scanner;

public class CharacterFrequency {

	// Method to find frequency of characters
	static String[][] findFrequency(String text) {

		int[] freq = new int[256]; // ASCII frequency array

		// Step 1: Count frequency of characters
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			freq[ch]++;
		}

		// Step 2: Count unique characters
		int uniqueCount = 0;
		for (int i = 0; i < text.length(); i++) {
			if (freq[text.charAt(i)] != 0) {
				uniqueCount++;
				freq[text.charAt(i)] = 0; // mark counted
			}
		}

		// Step 3: Create result 2D array
		String[][] result = new String[uniqueCount][2];

		// Reset frequency array
		for (int i = 0; i < 256; i++) {
			freq[i] = 0;
		}

		// Recalculate frequency
		for (int i = 0; i < text.length(); i++) {
			freq[text.charAt(i)]++;
		}

		// Step 4: Store character and frequency
		int index = 0;
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			if (freq[ch] != 0) {
				result[index][0] = String.valueOf(ch);
				result[index][1] = String.valueOf(freq[ch]);
				index++;
				freq[ch] = 0; // avoid duplicate entry
			}
		}

		return result;
	}

	// Main method
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String input = sc.nextLine();

		String[][] frequencyTable = findFrequency(input);

		// Display result
		System.out.println("\nCharacter Frequency:");
		System.out.println("----------------------");
		System.out.println("Character | Frequency");
		System.out.println("----------------------");

		for (int i = 0; i < frequencyTable.length; i++) {
			System.out.println("    " + frequencyTable[i][0] + "     |     " + frequencyTable[i][1]);
		}

		sc.close();
	}
}
