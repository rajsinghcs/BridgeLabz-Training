import java.util.Scanner;

public class StudentScoreCard {

    // Method 1: Take PCM marks input and return 2D array
    static int[][] inputPCMScores(int students, Scanner sc) {
        int[][] scores = new int[students][3];

        for (int i = 0; i < students; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1));

            System.out.print("Physics: ");
            scores[i][0] = sc.nextInt();

            System.out.print("Chemistry: ");
            scores[i][1] = sc.nextInt();

            System.out.print("Maths: ");
            scores[i][2] = sc.nextInt();
        }
        return scores;
    }

    // Method 2: Calculate total, average, percentage
    static double[][] calculateResults(int[][] scores) {
        double[][] result = new double[scores.length][3];

        for (int i = 0; i < scores.length; i++) {
            double total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3;
            double percentage = (total / 300) * 100;

            // Round to 2 decimal places
            result[i][0] = Math.round(total * 100.0) / 100.0;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return result;
    }

    // Method 3: Calculate grades based on percentage
    static char[] calculateGrades(double[][] result) {
        char[] grades = new char[result.length];

        for (int i = 0; i < result.length; i++) {
            double percentage = result[i][2];

            if (percentage >= 80)
                grades[i] = 'A';
            else if (percentage >= 70)
                grades[i] = 'B';
            else if (percentage >= 60)
                grades[i] = 'C';
            else if (percentage >= 50)
                grades[i] = 'D';
            else if (percentage >= 40)
                grades[i] = 'E';
            else
                grades[i] = 'R';
        }
        return grades;
    }

    // Method 4: Display scorecard
    static void displayScoreCard(int[][] scores, double[][] result, char[] grades) {

        System.out.println("\n------------------- STUDENT SCORECARD -------------------");
        System.out.println("Stu | Phy | Chem | Math | Total | Avg | % | Grade");
        System.out.println("---------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf(
                    "%3d | %3d | %4d | %4d | %5.2f | %4.2f | %5.2f | %c%n",
                    (i + 1),
                    scores[i][0],
                    scores[i][1],
                    scores[i][2],
                    result[i][0],
                    result[i][1],
                    result[i][2],
                    grades[i]
            );
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        int[][] scores = inputPCMScores(students, sc);
        double[][] result = calculateResults(scores);
        char[] grades = calculateGrades(result);

        displayScoreCard(scores, result, grades);

        sc.close();
    }
}

