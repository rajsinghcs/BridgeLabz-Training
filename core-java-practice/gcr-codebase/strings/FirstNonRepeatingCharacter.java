import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    // Method: Find first non-repeating character
    static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256];  // For all ASCII characters

        // First loop: Count frequency
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        // Second loop: Find first char with freq = 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) {
                return ch;
            }
        }

        return '\0'; // null character if no non-repeating char
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        char result = findFirstNonRepeatingChar(input);

        if (result == '\0') {
            System.out.println("No non-repeating character found.");
        } else {
            System.out.println("First non-repeating character: " + result);
        }

        sc.close();
    }
}

