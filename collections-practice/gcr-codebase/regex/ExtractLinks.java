import java.util.regex.*;

class ExtractLinks {

    public static void main(String[] args) {

        String text = "Visit https://www.google.com and http://example.org for more info.";

        String regex = "https?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        boolean first = true;

        while (matcher.find()) {
            if (!first)
                System.out.print(", ");
            System.out.print(matcher.group());
            first = false;
        }
    }
}
