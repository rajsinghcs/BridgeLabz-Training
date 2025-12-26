import java.util.*;
public class ToggleCase {
	public static void toggelString(String str) {
		String toggle_string = "";
		for(int i=0; i<str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i))) {
				toggle_string += Character.toLowerCase(str.charAt(i));
			}else {
				toggle_string += Character.toUpperCase(str.charAt(i));
			}
		}
		System.out.println("Toggle String: "+ toggle_string);
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		toggelString(str);
	}

}
