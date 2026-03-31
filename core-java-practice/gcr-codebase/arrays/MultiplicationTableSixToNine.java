import java.util.Scanner;

public class MultiplicationTableSixToNine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Array to store multiplication results
        int[] multiplicationResult = new int[4];

        // Calculate multiplication table
        int index = 0;
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[index] = number * i;
            index++;
        }

        // Display the multiplication table
        System.out.println("\nMultiplication Table of " + number + " (from 6 to 9):");
        index = 0;
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[index]);
            index++;
        }

        scanner.close();
    }
}
