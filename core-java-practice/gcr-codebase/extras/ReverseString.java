import java.util.*;

public class ReverseString {
	public static void reverseString(String str) {
		int len = str.length();
		String rev_str = "";
		for(int i=len-1; i>=0; i--) {
			rev_str += str.charAt(i)+"";
		}
		System.out.println("Reverse String is : "+ rev_str);
		
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		reverseString(str);
		
	}
}
