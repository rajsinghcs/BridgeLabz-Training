import java.util.Scanner;

public class FlipKeyLogicalProblem {

    //for cleanse and invert the input string
    public String CleanseAndInvert(String input) {
        if (input == null || input.length() < 6) {
            return "";
        }

        //for spaces, digits, or special characters
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!Character.isLetter(ch)) {
                return "";
            }
        }

        String lower = input.toLowerCase();

        // Remove characters with even ASCII values
        StringBuilder filtered = new StringBuilder();
        for (int i = 0; i < lower.length(); i++) {
            if ((int) lower.charAt(i) % 2 != 0) {
                filtered.append(lower.charAt(i));
            }
        }

        // Reverse the string
        filtered.reverse();

        // Uppercase characters at even positions
        for (int i = 0; i < filtered.length(); i++) {
            if (i % 2 == 0) {
                filtered.setCharAt(i, Character.toUpperCase(filtered.charAt(i)));
            }
        }

        return filtered.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word");
        String input = sc.nextLine();
        FlipKeyLogicalProblem p = new FlipKeyLogicalProblem();
        String result = p.CleanseAndInvert(input);

        if (result.isEmpty()) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("The generated key is - " + result);
        }
    }
}
