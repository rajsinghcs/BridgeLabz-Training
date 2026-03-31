import java.util.*;
public class LongestWord {
	public static void longestWord(String str) {
		String [] str_array = str.trim().split("\\s+"); 
		String longest_word = "";
		int word_len = 0;
		for(int i=0; i<str_array.length; i++) {
			if(word_len<str_array[i].length()) {
				word_len = str_array[i].length();
				longest_word = str_array[i];
			}
		}
		System.out.println("Longest word in This Sentence: "+longest_word);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		longestWord(str);
	}

}
