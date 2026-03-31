import java.util.*;
public class PalindromeString {
	public static String reverseString(String str) {
		int len = str.length();
		String rev_str = "";
		for(int i=len-1; i>=0; i--) {
			rev_str += str.charAt(i)+"";
		}
		return rev_str;
	}
		public static boolean palindromeString(String str, String rev_str) {
			if(str.equals(rev_str)) {
				return true;
			}
			return false;
		}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String rev = reverseString(str);
		System.out.println(palindromeString(str, rev));
	}

}
