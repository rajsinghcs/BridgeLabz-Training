import java.util.*;

public class SubstringCreation {

	// method for substring creation using char_at method
	static String substringUsingCharAt(String text, int start_idx, int end_idx) {
		String result = "";
		for (int i = start_idx; i < end_idx; i++) {
			result += text.charAt(i);
		}
		return result;
	}

	// method for substring comparision using char_At methods
	static boolean compareStrings(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// input string
		System.out.print("Enter text: ");
		String text = sc.next();

		// input start index
		System.out.print("Enter start index: ");
		int start_idx = sc.nextInt();

		// input end idx
		System.out.print("Enter end index: ");
		int end_idx = sc.nextInt();

		String customSub = substringUsingCharAt(text, start_idx, end_idx);
		// Substring creation using built_in method
		String builtInSub = text.substring(start_idx, end_idx);

		// display result of different methods
		System.out.println("Custom substring: " + customSub);
		System.out.println("Built-in substring: " + builtInSub);
		System.out.println("Comparison result: " + compareStrings(customSub, builtInSub));

		sc.close();
	}
}
