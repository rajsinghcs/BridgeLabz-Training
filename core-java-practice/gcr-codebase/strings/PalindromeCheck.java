
import java.util.Scanner;

public class PalindromeCheck {

	// LOGIC 1: Using start and end index comparison
	static boolean isPalindromeUsingLoop(String text) {

		int start = 0;
		int end = text.length() - 1;

		while (start < end) {
			if (text.charAt(start) != text.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	// LOGIC 2: Using Recursion
	static boolean isPalindromeRecursive(String text, int start, int end) {

		if (start >= end) {
			return true;
		}

		if (text.charAt(start) != text.charAt(end)) {
			return false;
		}

		return isPalindromeRecursive(text, start + 1, end - 1);
	}

	// Method to reverse string using charAt()
	static char[] reverseString(String text) {

		char[] reverse = new char[text.length()];
		int index = 0;

		for (int i = text.length() - 1; i >= 0; i--) {
			reverse[index] = text.charAt(i);
			index++;
		}

		return reverse;
	}

	// LOGIC 3: Using Character Arrays
	static boolean isPalindromeUsingArray(String text) {

		char[] original = text.toCharArray();
		char[] reverse = reverseString(text);

		for (int i = 0; i < original.length; i++) {
			if (original[i] != reverse[i]) {
				return false;
			}
		}
		return true;
	}

	// Main method
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a text: ");
		String input = sc.nextLine();

		boolean result1 = isPalindromeUsingLoop(input);
		boolean result2 = isPalindromeRecursive(input, 0, input.length() - 1);
		boolean result3 = isPalindromeUsingArray(input);

		System.out.println("\nPalindrome Check Results:");
		System.out.println("-------------------------");
		System.out.println("Using Loop Logic      : " + result1);
		System.out.println("Using Recursion Logic : " + result2);
		System.out.println("Using Array Logic     : " + result3);

		sc.close();
	}
}
