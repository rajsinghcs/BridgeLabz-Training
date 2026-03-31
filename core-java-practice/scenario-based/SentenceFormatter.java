public class SentenceFormatter {

    // Method to format the paragraph
    public static String formatParagraph(String input) {

        // Handle empty or null input
        if (input == null || input.trim().isEmpty()) {
            return "Input paragraph is empty.";
        }

        // Step 1: Remove extra spaces
        input = input.trim().replaceAll("\\s+", " ");

        // Step 2: one space after punctuation 
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            sb.append(ch);

            // Add space after punctuation
            if (ch == '.' || ch == '?' || ch == '!') {
                if (i + 1 < input.length() && input.charAt(i + 1) != ' ') {
                    sb.append(' ');
                }
            }
        }

        input = sb.toString().trim();

        // Step 3: Capitalize first letter of each sentence
        StringBuilder formatted = new StringBuilder();
        boolean capitalizeNext = true;

        for (char ch : input.toCharArray()) {

            if (capitalizeNext && Character.isLetter(ch)) {
                formatted.append(Character.toUpperCase(ch));
                capitalizeNext = false;
            } else {
                formatted.append(ch);
            }

            if (ch == '.' || ch == '?' || ch == '!') {
                capitalizeNext = true;
            }
        }

        return formatted.toString().trim();
    }

    public static void main(String[] args) {

        String text = "  hello world.this   is a lab!how are you?i am fine.  ";
        System.out.println(formatParagraph(text));
    }
}
