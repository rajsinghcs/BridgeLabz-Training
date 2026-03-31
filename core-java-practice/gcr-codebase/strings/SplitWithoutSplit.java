import java.util.Scanner;

public class SplitWithoutSplit {

	static String[] customSplit(String text) {
		int wordCount = 1;
		for (int i = 0; i < text.length(); i++)
			if (text.charAt(i) == ' ')
				wordCount++;

		int[] spaceIndex = new int[wordCount - 1];
		int idx = 0;

		for (int i = 0; i < text.length(); i++)
			if (text.charAt(i) == ' ')
				spaceIndex[idx++] = i;

		String[] words = new String[wordCount];
		int start = 0;

		for (int i = 0; i < spaceIndex.length; i++) {
			words[i] = text.substring(start, spaceIndex[i]);
			start = spaceIndex[i] + 1;
		}
		words[wordCount - 1] = text.substring(start);

		return words;
	}

	static boolean compareArrays(String[] a, String[] b) {
		if (a.length != b.length)
			return false;
		for (int i = 0; i < a.length; i++)
			if (!a[i].equals(b[i]))
				return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter text: ");
		String text = sc.nextLine();

		String[] custom = customSplit(text);
		String[] builtIn = text.split(" ");

		System.out.println("Result matched: " + compareArrays(custom, builtIn));
		sc.close();
	}
}
