import java.util.*;

public class DeleteCharactersToMakeFancyString {
    public static String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            int n = result.length();
            if (n < 2 || !(result.charAt(n - 1) == c && result.charAt(n - 2) == c)) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        String fancyString = makeFancyString(s);
        System.out.println("Fancy String: " + fancyString);

        sc.close();
    }
}
