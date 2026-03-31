import java.util.Scanner;

public class BmiForTeam {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take number of persons
        System.out.print("Enter number of persons: ");
        int count = scanner.nextInt();

        if (count <= 0) {
            System.out.println("Invalid number of persons.");
            scanner.close();
            return;
        }

        // Arrays to store data
        double[] weight = new double[count]; // in kg
        double[] heightCm = new double[count]; // in centimeters
        double[] bmi = new double[count];
        String[] status = new String[count];

        // Input height and weight
        System.out.println("\nEnter weight (kg) and height (cm) of each person:");
        for (int i = 0; i < count; i++) {
            System.out.println("\nPerson " + (i + 1));

            System.out.print("Weight (kg): ");
            weight[i] = scanner.nextDouble();

            System.out.print("Height (cm): ");
            heightCm[i] = scanner.nextDouble();

            // Validate input
            if (weight[i] <= 0 || heightCm[i] <= 0) {
                System.out.println("Invalid input! Please enter again.");
                i--; // repeat current person
            }
        }

        // Calculate BMI and weight status
        for (int i = 0; i < count; i++) {
            double heightMeters = heightCm[i] / 100; // convert cm to meters
            bmi[i] = weight[i] / (heightMeters * heightMeters);

            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmi[i] < 25) {
                status[i] = "Normal";
            } else if (bmi[i] < 40) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        // Display results
        System.out.println("\nBMI Details:");
        System.out.println("---------------------------------------------------");
        System.out.println("Person | Height(cm) | Weight(kg) | BMI | Status");
        System.out.println("---------------------------------------------------");

        for (int i = 0; i < count; i++) {
            System.out.printf(
                    "%6d | %10.2f | %10.2f | %4.2f | %s%n",
                    (i + 1), heightCm[i], weight[i], bmi[i], status[i]);
        }

        scanner.close();
    }
}
