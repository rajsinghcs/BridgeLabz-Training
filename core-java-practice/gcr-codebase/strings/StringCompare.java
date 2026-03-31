import java.util.*;

public class StringCompare {

	// string comparision using char_At methods
	static boolean compareUsingCharAt(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// input string1
		System.out.print("Enter first string: ");
		String str1 = sc.next();

		// input string2
		System.out.print("Enter second string: ");
		String str2 = sc.next();

		// built_in method for string comparision
		boolean charAtResult = compareUsingCharAt(str1, str2);
		boolean equalsResult = str1.equals(str2);

		// display result of two different method of string comparision
		System.out.println("charAt comparison result: " + charAtResult);
		System.out.println("equals() comparison result: " + equalsResult);

		sc.close();
	}
}
