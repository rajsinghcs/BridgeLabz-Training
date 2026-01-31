class UsernameValidation {

    public static boolean isValidUsername(String username) {

        if (username.length() < 5 || username.length() > 15)
            return false;

        char first = username.charAt(0);
        if (!Character.isLetter(first))
            return false;

        for (int i = 0; i < username.length(); i++) {
            char ch = username.charAt(i);

            if (!(Character.isLetterOrDigit(ch) || ch == '_'))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidUsername("user_123")); 
        System.out.println(isValidUsername("123user"));  
        System.out.println(isValidUsername("us"));      
    }
}
