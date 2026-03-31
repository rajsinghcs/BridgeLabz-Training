public class StringUtils {

    public String reverseString(String s) {
        if (s == null) return null;

        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        return rev;
    }

    public boolean isPalindrome(String s) {
        if (s == null) return false;
        return reverseString(s).equals(s);
    }

    public String toUpperCase(String s) {
        if (s == null) return null;

        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLowerCase(ch)) {
                str += Character.toUpperCase(ch);
            } else {
                str += ch;
            }
        }
        return str;
    }

}
