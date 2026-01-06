import java.util.*;

public class StudentScoreAnalyzer {

    public static void validateScores(int[] mathExamScore) {
        for (int score : mathExamScore) {
            if (score < 0 || score > 100) {
                throw new InvalidScoreException(
                    "Invalid score found: " + score + " (Score must be between 0 and 100)"
                );
            }
        }
    }

    public static int findMin(int[] mathExamScore) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < mathExamScore.length; i++) {
            min = Math.min(min, mathExamScore[i]);
        }
        return min;
    }

    public static int findMax(int[] mathExamScore) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mathExamScore.length; i++) {
            max = Math.max(max, mathExamScore[i]);
        }
        return max;
    }

    public static double calculateAverage(int[] mathExamScore) {
        int sum = 0;
        for (int i = 0; i < mathExamScore.length; i++) {
            sum += mathExamScore[i];
        }
        return (double) sum / mathExamScore.length;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Student");
        int len = sc.nextInt();
        
        System.out.println("Enter marks of Students : ");
        int[] mathExamScore = new int[len];
        for (int i = 0; i < len; i++) {
            mathExamScore[i] = sc.nextInt();
        }

        try {
            validateScores(mathExamScore);

            System.out.println("Average Score: " + calculateAverage(mathExamScore));
            System.out.println("Highest Score: " + findMax(mathExamScore));
            System.out.println("Lowest Score: " + findMin(mathExamScore));

        } catch (InvalidScoreException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}

// Custom Exception in SAME FILE (non-public)
class InvalidScoreException extends RuntimeException {

    public InvalidScoreException(String message) {
        super(message);
    }
}
