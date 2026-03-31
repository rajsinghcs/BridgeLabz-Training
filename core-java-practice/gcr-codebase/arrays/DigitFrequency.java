import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = sc.nextLong(); // Use long to handle large numbers

        // Step 1: Find the count of digits
        long temp = number;
        int count = 0;
        while (temp != 0) {
            temp /= 10;
            count++;
        }

        // Step 2: Extract digits and store in an array
        int[] digits = new int[count];
        temp = number;
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = (int) (temp % 10);
            temp /= 10;
        }

        // Step 3: Find frequency of each digit
        int[] frequency = new int[10]; // Index 0-9 for digits
        for (int i = 0; i < count; i++) {
            frequency[digits[i]]++;
        }

        // Step 4: Display frequency of each digit
        System.out.println("\nDigit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " time(s)");
            }
        }

        sc.close();
    }
}
