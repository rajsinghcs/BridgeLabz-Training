class LicensePlateValidation {

    public static boolean isValidPlate(String plate) {

        if (plate.length() != 6)
            return false;

        for (int i = 0; i < 2; i++) {
            char ch = plate.charAt(i);
            if (ch < 'A' || ch > 'Z')
                return false;
        }

        for (int i = 2; i < 6; i++) {
            char ch = plate.charAt(i);
            if (ch < '0' || ch > '9')
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidPlate("AB1234")); 
        System.out.println(isValidPlate("A12345"));
        System.out.println(isValidPlate("ab1234"));
    }
}
