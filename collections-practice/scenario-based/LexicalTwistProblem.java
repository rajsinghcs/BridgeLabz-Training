import java.util.*;

public class LexicalTwistProblem {

    // method for word contains spaces or not
    public static boolean isValidWord(String word) {
        return !word.contains(" ");
    }

    // method to reverse a string
    public static String reverseWord(String word) {
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }
        return reversed;
    }

    // method to replace vowels with '@'
    public static String replaceVowels(String word) {
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if ("aeiou".indexOf(ch) >= 0) {
                result += "@";
            } else {
                result += ch;
            }
        }
        return result;
    }

    // method to check character is a vowel
    public static boolean isVowel(char ch) {
        return "AEIOU".indexOf(ch) >= 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first word");
        String first = sc.nextLine();

        System.out.println("Enter the second word");
        String second = sc.nextLine();

        if (!isValidWord(first)) {
            System.out.println(first + " is an invalid word");
            return;
        }
        if (!isValidWord(second)) {
            System.out.println(second + " is an invalid word");
            return;
        }

        if (second.equalsIgnoreCase(reverseWord(first))) {
            String reversed = reverseWord(first);
            reversed = reversed.toLowerCase();
            reversed = replaceVowels(reversed);
            System.out.println(reversed);

        } else {
            String combined = first + second;
            combined = combined.toUpperCase();

            int vowelsCount = 0;
            int consonantsCount = 0;

            // count vowels and consonants
            for (int i = 0; i < combined.length(); i++) {
                char ch = combined.charAt(i);
                if (ch >= 'A' && ch <= 'Z') {
                    if (isVowel(ch))
                        vowelsCount++;
                    else
                        consonantsCount++;
                }
            }

            // for collecting first 2 unique vowels/consonants
            LinkedHashSet<Character> uniqueVowels = new LinkedHashSet<>();
            LinkedHashSet<Character> uniqueConsonants = new LinkedHashSet<>();

            for (int i = 0; i < combined.length(); i++) {
                char ch = combined.charAt(i);
                if (ch >= 'A' && ch <= 'Z') {
                    if (isVowel(ch) && uniqueVowels.size() < 2)
                        uniqueVowels.add(ch);
                    else if (!isVowel(ch) && uniqueConsonants.size() < 2)
                        uniqueConsonants.add(ch);
                }
            }

            if (vowelsCount > consonantsCount) {
                for (char ch : uniqueVowels)
                    System.out.print(ch);
                System.out.println();
            } else if (consonantsCount > vowelsCount) {
                for (char ch : uniqueConsonants)
                    System.out.print(ch);
                System.out.println();
            } else {
                System.out.println("Vowels and consonants are equal");
            }
        }
    }
}
