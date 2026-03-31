class ValidateCreditCard {

    public static boolean isValidCard(String card) {

        if (card.length() != 16)
            return false;

        for (int i = 0; i < 16; i++) {
            if (!Character.isDigit(card.charAt(i)))
                return false;
        }

        char first = card.charAt(0);
        if (first == '4') {
            return true;
        } else if (first == '5') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidCard("4123456789012345")); 
        System.out.println(isValidCard("5123456789012345"));
        System.out.println(isValidCard("6123456789012345")); 
        System.out.println(isValidCard("412345678901234"));  
        System.out.println(isValidCard("4123abcd89012345"));
    }
}
