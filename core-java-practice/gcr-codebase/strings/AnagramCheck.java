import java.util.Scanner;

public class AnagramCheck {

	// Method to check if two texts are anagrams
	static boolean isAnagram(String text1, String text2) {

		// Remove spaces (optional but useful)
		text1 = text1.replace(" ", "");
		text2 = text2.replace(" ", "");

		// Check length
		if (text1.length() != text2.length()) {
			return false;
		}

		// Frequency arrays for ASCII characters
		int[] freq1 = new int[256];
		int[] freq2 = new int[256];

		// Count frequency of characters in text1
		for (int i = 0; i < text1.length(); i++) {
			freq1[text1.charAt(i)]++;
		}

		// Count frequency of characters in text2
		for (int i = 0; i < text2.length(); i++) {
			freq2[text2.charAt(i)]++;
		}

		// Compare frequencies
		for (int i = 0; i < 256; i++) {
			if (freq1[i] != freq2[i]) {
				return false;
			}
		}

		return true;
	}

	// Main method
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter first text: ");
		String text1 = sc.nextLine();

		System.out.print("Enter second text: ");
		String text2 = sc.nextLine();

		boolean result = isAnagram(text1, text2);

		System.out.println("\nResult:");
		if (result) {
			System.out.println("The texts are Anagrams.");
		} else {
			System.out.println("The texts are NOT Anagrams.");
		}

		sc.close();
	}
}
