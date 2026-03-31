import java.util.Scanner;
public class MayaBMIFitnessTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input height in centimeters and weight in kilograms
        System.out.print("Enter height in centimeters: ");
        double heightInCm = scanner.nextDouble();

        System.out.print("Enter weight in kilograms: ");
        double weightInKg = scanner.nextDouble();

        // Convert height from cm to meters
        double heightInMeters = heightInCm / 100;

        // BMI calculation
        double bmi = weightInKg / (heightInMeters * heightInMeters);

        System.out.println("Your BMI is: " + bmi);

        // BMI category check
        if (bmi < 18.5) {
            System.out.println("Category: Underweight");
        } else if (bmi < 25) {
            System.out.println("Category: Normal");
        } else {
            System.out.println("Category: Overweight");
        }

        scanner.close();
    }
}
