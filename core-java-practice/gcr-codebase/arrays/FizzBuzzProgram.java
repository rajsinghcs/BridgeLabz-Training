import java.util.Scanner;

public class FizzBuzzProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // input from user
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Validate input
        if (number <= 0) {
            System.out.println("Error: Please enter a positive integer.");
            scanner.close();
            return;
        }

        // String array to store results
        String[] result = new String[number + 1];

        // Fill the array using FizzBuzz logic
        for (int i = 0; i <= number; i++) {
            if (i == 0) {
                result[i] = "0";
            } else if (i % 3 == 0 && i % 5 == 0) {
                result[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                result[i] = "Fizz";
            } else if (i % 5 == 0) {
                result[i] = "Buzz";
            } else {
                result[i] = String.valueOf(i);
            }
        }

        // Display results with index position
        System.out.println("\nFizzBuzz Results:");
        for (int i = 0; i <= number; i++) {
            System.out.println("Position " + i + " = " + result[i]);
        }

        scanner.close();
    }
}
