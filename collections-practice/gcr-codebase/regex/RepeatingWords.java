import java.util.*;

class RepeatingWords {

    public static void main(String[] args) {

        String text = "This is is a repeated repeated word test.";
        String[] words = text.split("\\s+");

        Set<String> seen = new HashSet<>();
        Set<String> repeated = new LinkedHashSet<>();

        for (String word : words) {
            word = word.toLowerCase(); 
            if (seen.contains(word)) {
                repeated.add(word);
            } else {
                seen.add(word);
            }
        }

        boolean first = true;
        for (String word : repeated) {
            if (!first) System.out.print(", ");
            System.out.print(word);
            first = false;
        }
    }
}
