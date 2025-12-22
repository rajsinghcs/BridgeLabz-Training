import java.util.Scanner;
public class StringLengthWithoutLength {

    static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (RuntimeException e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.next();

        System.out.println("Custom length: " + findLength(text));
        System.out.println("Built-in length: " + text.length());
        sc.close();
    }
}
