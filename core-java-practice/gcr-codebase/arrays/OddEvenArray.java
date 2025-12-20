import java.util.Scanner;

public class OddEvenArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();

        // Check for natural number
        if (number <= 0) {
            System.out.println("Error: Please enter a valid natural number.");
            scanner.close();
            return;
        }

        // Create arrays for odd and even numbers
        int size = number / 2 + 1;
        int[] oddNumbers = new int[size];
        int[] evenNumbers = new int[size];

        // Index variables
        int oddIndex = 0;
        int evenIndex = 0;

        // Iterate from 1 to number
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }

        // Print odd numbers
        System.out.println("\nOdd Numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }

        // Print even numbers
        System.out.println("\n\nEven Numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }

        scanner.close();
    }
}
