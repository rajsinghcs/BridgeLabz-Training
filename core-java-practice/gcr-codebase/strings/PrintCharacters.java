import java.util.*;

public class PrintCharacters {
	
	//method for getting characters using charAt method
	static char[] getCharsUsingCharAt(String text) {
		char[] arr = new char[text.length()];
		for (int i = 0; i < text.length(); i++) {
			arr[i] = text.charAt(i);
		}
		return arr;
	}
    
	//method for comparing two strings
	static boolean compareCharArrays(char[] a, char[] b) {
		if (a.length != b.length)
			return false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//input string
		System.out.print("Enter text: ");
		String text = sc.next();
         
		//String array for getting characters of two different method 
		char[] customArray = getCharsUsingCharAt(text);
		char[] builtInArray = text.toCharArray();
        
		//display comparision result
		System.out.println("Arrays equal: " + compareCharArrays(customArray, builtInArray));

		sc.close();
	}
}
