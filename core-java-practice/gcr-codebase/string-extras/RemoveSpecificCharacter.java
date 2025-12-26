import java.util.*;
public class RemoveSpecificCharacter {
	public static void removesSpecificCharacters(String str, char ch) {
		String remove_character = "";
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == ch) {
				continue;
			}else {
				remove_character += str.charAt(i);
			}
		}
		System.out.println("Modified String: "+remove_character);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char ch = sc.next().charAt(0);
		removesSpecificCharacters(str, ch);
	}

}
