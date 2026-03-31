import java.util.Scanner;

public class StudentScoreAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] scores = new int[n];
        int sum = 0;

        // Input with validation
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Enter score for student " + (i + 1) + ": ");

                if (!sc.hasNextInt()) {
                    System.out.println("Invalid input! Enter a numeric value.");
                    sc.next(); // clear invalid input
                    continue;
                }

                int score = sc.nextInt();

                if (score < 0) {
                    System.out.println("Score cannot be negative.");
                } else {
                    scores[i] = score;
                    sum += score;
                    break;
                }
            }
        }

        double average = (double) sum / n;
        int max = scores[0];
        int min = scores[0];

        for (int score : scores) {
            if (score > max) max = score;
            if (score < min) min = score;
        }

        System.out.println("\nAverage Score: " + average);
        System.out.println("Highest Score: " + max);
        System.out.println("Lowest Score: " + min);

        System.out.println("Scores above average:");
        for (int score : scores) {
            if (score > average) {
                System.out.println(score);
            }
        }

        sc.close();
    }
}
