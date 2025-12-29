import java.util.Scanner;

public class AnagramStrings {
	public static void anagramStrings(String str1, String str2) {
		if(str1.length() != str2.length()) {
			System.out.println("Not Anagram");
			return;
		}
		int [] freq = new int[256];
		for(int i=0; i<str1.length(); i++) {
			freq[str1.charAt(i)]++;
		}
		for(int i=0; i<str2.length(); i++) {
			freq[str2.charAt(i)]--;
		}
		for(int i=0; i<str1.length(); i++) {
			if(freq[str1.charAt(i)] != 0) {
				System.out.println("Not Anagram");
				return;
			}
		}
		System.out.println("Anagram");
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		anagramStrings(str1, str2);
	}


}
