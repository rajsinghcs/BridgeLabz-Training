import java.util.regex.*;

class ExtractCurrency {

    public static void main(String[] args) {

        String text = "The price is $45.99, and the discount is 10.50.";
        String regex = "\\$?\\d+\\.\\d{2}";

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
