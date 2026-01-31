import java.util.regex.*;

class ValidateSSN {

    public static boolean isValidSSN(String ssn) {
        String regex = "\\d{3}-\\d{2}-\\d{4}";
        return ssn.matches(regex);
    }

    public static void main(String[] args) {

        String text1 = "123-45-6789";
        String text2 = "123456789";

        System.out.println(text1 + " -> " + isValidSSN(text1));
        System.out.println(text2 + " -> " + isValidSSN(text2));
    }
}
