import java.util.Base64;

public class EncryptDecrypt {
    public static void main(String[] args) {
        String salary = "50000";

        String encrypted = Base64.getEncoder().encodeToString(salary.getBytes());
        String decrypted = new String(Base64.getDecoder().decode(encrypted));

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
