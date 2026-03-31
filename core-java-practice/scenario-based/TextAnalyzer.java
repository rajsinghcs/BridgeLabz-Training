public class TextAnalyzer {

    public static void analyzeText(String paragraph, String oldWord, String newWord) {

        // check empty paragraph
        if (paragraph == null || paragraph.trim().isEmpty()) {
            System.out.println("Paragraph is empty.");
            return;
        }

        String[] words = paragraph.trim().split("\\s+");

        // Word count
        System.out.println("Word Count: " + words.length);

        // Find longest word
        String longestWord = words[0];
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        System.out.println("Longest Word: " + longestWord);

        // Replace word (case-insensitive) 
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.equalsIgnoreCase(oldWord)) {
                result.append(newWord);
            } else {
                result.append(word);
            }
            result.append(" ");
        }

        String replacedText = result.toString().trim();

        System.out.println("Updated Paragraph:");
        System.out.println(replacedText);
    }

    public static void main(String[] args) {

        String paragraph = "Java is powerful. java is widely used in enterprise applications.";
        analyzeText(paragraph, "java", "Java™");
    }
}
