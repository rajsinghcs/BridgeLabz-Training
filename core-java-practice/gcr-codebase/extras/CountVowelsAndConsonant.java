import java.util.*;
public class CountVowelsAndConsonant {
public static void countVowelConsonant(String str) {
	int len = str.length();
	String vowel = "aeiou";
	int v_counter = 0;
	int c_counter = 0;
	for(int i=0; i<len; i++) {
		if(Character.isLetter(str.charAt(i))) {
			if(vowel.indexOf(str.charAt(i)) != -1) {
				v_counter++;
			}else {
				c_counter++;
			}
		}
	}
	System.out.println("Vowels- "+ v_counter +" and "+"Consonants- " +c_counter);
}
	public static void main(String args []) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next().toLowerCase();
		countVowelConsonant(str);
	}

}
