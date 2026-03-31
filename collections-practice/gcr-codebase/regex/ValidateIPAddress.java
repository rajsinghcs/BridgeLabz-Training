class ValidateIPAddress {

    public static boolean isValidIP(String ip) {

        String[] parts = ip.split("\\.");

        if (parts.length != 4)
            return false;

        for (String part : parts) {
            try {
                int num = Integer.parseInt(part);

                if (num < 0 || num > 255)
                    return false;

                if (!part.equals(String.valueOf(num)))
                    return false;

            } catch (NumberFormatException e) {
                return false; 
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidIP("192.168.1.1"));    
        System.out.println(isValidIP("256.100.50.0"));
        System.out.println(isValidIP("192.168.01.1"));
        System.out.println(isValidIP("192.168.1"));   
        System.out.println(isValidIP("abc.def.1.1"));
    }
}
