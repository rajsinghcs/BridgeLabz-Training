import java.util.Scanner;

public class ReplaceWordString {
	public static void replaceWord(String sentence, String str1, String str2) {
		String [] word_array = sentence.trim().split("\\s+");
		for(int i=0; i<word_array.length; i++) {
			if(word_array[i].equals(str1)) {
				word_array[i] = str2;
			}
		}
		for(int i=0; i<word_array.length; i++) {
		System.out.print(word_array[i]+" ");
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();
		String matching_word = sc.next();
		String replace_word = sc.next();
		replaceWord(sentence, matching_word, replace_word);
	}
}
