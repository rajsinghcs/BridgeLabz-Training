class HexColorValidation {

    public static boolean isValidHexColor(String color) {

        if (color.charAt(0) != '#')
            return false;

        if (color.length() != 7)
            return false;

        for (int i = 1; i < color.length(); i++) {
            char ch = color.charAt(i);

            boolean isDigit = (ch >= '0' && ch <= '9');
            boolean isUpperHex = (ch >= 'A' && ch <= 'F');
            boolean isLowerHex = (ch >= 'a' && ch <= 'f');

            if (!(isDigit || isUpperHex || isLowerHex))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidHexColor("#FFA500")); 
        System.out.println(isValidHexColor("#ff4500"));
        System.out.println(isValidHexColor("#123"));   
    }
}
