import java.util.Scanner;

public class ReverseNumberUsingArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Validate input
        if (number < 0) {
            System.out.println("Please enter a non-negative number.");
            scanner.close();
            return;
        }

        // Find count of digits
        int temp = number;
        int count = 0;

        if (temp == 0) {
            count = 1;
        } else {
            while (temp != 0) {
                count++;
                temp = temp / 10;
            }
        }

        // array to store digits
        int[] digits = new int[count];

        // Extract digits and store in array
        temp = number;
        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp = temp / 10;
        }

        // Create array to store reversed digits
        int[] reversedDigits = new int[count];

        for (int i = 0; i < count; i++) {
            reversedDigits[i] = digits[count - 1 - i];
        }

        // Display reversed number
        System.out.print("\nReversed Number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(reversedDigits[i]);
        }

        scanner.close();
    }
}
