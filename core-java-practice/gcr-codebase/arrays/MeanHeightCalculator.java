import java.util.Scanner;

public class MeanHeightCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array to store heights of 11 players
        double[] heights = new double[11];

        double sum = 0.0;

        // Input heights from user
        System.out.println("Enter the heights of 11 football players (in cm):");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + " height: ");
            heights[i] = scanner.nextDouble();
            sum += heights[i];
        }

        // for mean height
        double meanHeight = sum / heights.length;

        // Display result
        System.out.println("\nMean Height of the Football Team: " + meanHeight + " cm");

        scanner.close();
    }
}
