import java.util.Scanner;

public class ArraySum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array to store 10 values
        double[] numbers = new double[10];

        // Variable to store sum
        double total = 0.0;

        // Index for array
        int index = 0;

        // Infinite loop for user input
        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double input = scanner.nextDouble();

            // Stop if input is 0 or negative
            if (input <= 0) {
                break;
            }

            // Stop if array is full
            if (index == 10) {
                System.out.println("Maximum limit of 10 numbers reached.");
                break;
            }

            numbers[index] = input;
            index++;
        }

        // Calculate total using for loop
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }

        // Display entered numbers
        System.out.println("\nEntered Numbers:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
        }

        // Display total sum
        System.out.println("\nTotal Sum: " + total);

        scanner.close();
    }
}
