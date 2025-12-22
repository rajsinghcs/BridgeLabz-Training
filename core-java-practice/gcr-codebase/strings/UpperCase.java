import java.util.*;
public class UpperCase {

    static String toUpperUsingCharAt(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }
            result += ch;
        }
        return result;
    }

    static boolean compareStrings(String a, String b) {
        return a.equals(b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String customUpper = toUpperUsingCharAt(text);
        String builtInUpper = text.toUpperCase();

        System.out.println("Result matched: " +
                compareStrings(customUpper, builtInUpper));

        sc.close();
    }
}
