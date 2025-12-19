import java.util.Scanner;
public class PowerOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the base number:");
        int base = sc.nextInt();
        System.out.println("Enter the exponent:");
        int exponent = sc.nextInt();
        if(exponent < 0) {
            System.out.println("Exponent should be a non-negative integer.");
            return;
        }
        int result = 1;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        System.out.println(base + " raised to the power of " + exponent + " is: " + result);
    }
}