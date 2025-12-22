import java.util.Scanner;

public class UniqueCharacterFrequency {

    // Method to find unique characters using nested loops
    static char[] uniqueCharacters(String text) {

        char[] temp = new char[text.length()];
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < i; j++) {
                if (current == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[count] = current;
                count++;
            }
        }

        // Create exact-sized array
        char[] uniqueChars = new char[count];
        for (int i = 0; i < count; i++) {
            uniqueChars[i] = temp[i];
        }

        return uniqueChars;
    }

    // Method to find frequency using unique characters
    static String[][] characterFrequency(String text) {

        int[] freq = new int[256];

        // Count frequency using ASCII
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        // Get unique characters
        char[] uniqueChars = uniqueCharacters(text);

        // Create result array
        String[][] result = new String[uniqueChars.length][2];

        for (int i = 0; i < uniqueChars.length; i++) {
            char ch = uniqueChars[i];
            result[i][0] = String.valueOf(ch);
            result[i][1] = String.valueOf(freq[ch]);
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        String[][] frequencyTable = characterFrequency(input);

        // Display result
        System.out.println("\nCharacter Frequency:");
        System.out.println("----------------------");
        System.out.println("Character | Frequency");
        System.out.println("----------------------");

        for (int i = 0; i < frequencyTable.length; i++) {
            System.out.println("    " + frequencyTable[i][0] +
                               "     |     " + frequencyTable[i][1]);
        }

        sc.close();
    }
}

