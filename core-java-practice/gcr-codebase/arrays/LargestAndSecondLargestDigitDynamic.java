import java.util.Scanner;

public class LargestAndSecondLargestDigitDynamic {

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

        // Initial max digit size
        int maxDigit = 10;

        // Array to store digits
        int[] digits = new int[maxDigit];

        // Index variable
        int index = 0;

        // Extract digits and store dynamically
        while (number != 0) {

            // Resize array if index reaches maxDigit
            if (index == maxDigit) {
                maxDigit = maxDigit + 10;
                int[] temp = new int[maxDigit];

                // Copy old digits to new array
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }

                digits = temp;
            }

            // Store digit
            digits[index] = number % 10;
            index++;

            // Remove last digit
            number = number / 10;
        }

        // Variables to store largest and second largest digits
        int largest = 0;
        int secondLargest = 0;

        // Find largest and second largest
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        // Display results
        System.out.println("\nLargest Digit: " + largest);
        System.out.println("Second Largest Digit: " + secondLargest);

        scanner.close();
    }
}
