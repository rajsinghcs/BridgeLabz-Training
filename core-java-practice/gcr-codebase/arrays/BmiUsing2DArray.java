import java.util.Scanner;

public class BmiUsing2DArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take number of persons
        System.out.print("Enter number of persons: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Invalid number of persons.");
            scanner.close();
            return;
        }

        // 2D array to store weight, height, BMI
        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        // Input weight and height
        for (int i = 0; i < number; i++) {
            System.out.println("\nPerson " + (i + 1));

            System.out.print("Enter weight (kg): ");
            personData[i][0] = scanner.nextDouble();

            System.out.print("Enter height (cm): ");
            personData[i][1] = scanner.nextDouble();

            // Validate input
            if (personData[i][0] <= 0 || personData[i][1] <= 0) {
                System.out.println("Invalid input! Please enter positive values.");
                i--; // repeat current person
            }
        }

        // Calculate BMI and weight status
        for (int i = 0; i < number; i++) {
            double heightInMeters = personData[i][1] / 100;

            personData[i][2] = personData[i][0] / (heightInMeters * heightInMeters);

            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 25) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Display results
        System.out.println("\nBMI Details:");
        System.out.println("---------------------------------------------------");
        System.out.println("Person | Height(cm) | Weight(kg) | BMI | Status");
        System.out.println("---------------------------------------------------");

        for (int i = 0; i < number; i++) {
            System.out.printf(
                    "%6d | %10.2f | %10.2f | %4.2f | %s%n",
                    (i + 1),
                    personData[i][1],
                    personData[i][0],
                    personData[i][2],
                    weightStatus[i]);
        }

        scanner.close();
    }
}
