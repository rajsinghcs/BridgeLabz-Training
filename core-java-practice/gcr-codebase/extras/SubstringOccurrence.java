import java.util.*;
public class SubstringOccurrence {
	public static void countSubstring(String str, String sub_str) {
		int counter = 0;
		int index = 0;
		while((index = str.indexOf(sub_str,index)) != -1){
			counter++;
			index++;
		}
		System.out.println(counter);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next().toLowerCase();
		String sub_str = sc.next().toLowerCase();
		countSubstring(str,sub_str);
	}
}
