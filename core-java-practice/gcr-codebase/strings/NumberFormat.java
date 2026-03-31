import java.util.*;
public class NumberFormat {

    static void generateException(String text) {
        int num = Integer.parseInt(text);
        System.out.println(num);
    }

    static void handleException(String text) {
        try {
            int num = Integer.parseInt(text);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException handled");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException handled");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number text: ");
        String text = sc.next();

        // generateException(text);
        handleException(text);
        sc.close();
    }
}
