import java.util.*;
public class RemovesDuplicates {
	public static void removesDuplicates(String str) {
		int len = str.length();
		String removes_duplicate = "";
		for(int i=0; i<len; i++) {
			if(removes_duplicate.indexOf(str.charAt(i)) == -1) {
				removes_duplicate += str.charAt(i)+"";
			}
		}
		System.out.println("String after removing duplicates: "+ removes_duplicate );
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		removesDuplicates(str);
	}
}
