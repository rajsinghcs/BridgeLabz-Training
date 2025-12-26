import java.util.*;
public class CompareTwoString {
	public static void compareString(String str1, String str2) {
		int result = 0;
		int len = Math.min(str1.length(), str2.length());
		for(int i=0; i<len; i++) {
			if(str1.charAt(i) != str2.charAt(i)) {
				result = str1.charAt(i)- str2.charAt(i);
				break;
			}			
		}
		if(result == 0) {
			result = str1.length()- str2.length();
		}
		if (result < 0) {
			System.out.println("\"str1\" comes before \"str2\" in lexicographical order");
        } else if (result > 0) {
            System.out.println("String 1 comes after String 2");
        } else {
            System.out.println("Both strings are equal");
        }
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next().toLowerCase();
		String str2 = sc.next().toLowerCase();
		compareString(str1, str2);
		
	}
}
