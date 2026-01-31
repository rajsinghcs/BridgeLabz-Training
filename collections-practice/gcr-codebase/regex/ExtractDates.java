import java.util.regex.*;

class ExtractDates {

    public static void main(String[] args) {

        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";

        String regex = "\\b\\d{2}/\\d{2}/\\d{4}\\b";

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
