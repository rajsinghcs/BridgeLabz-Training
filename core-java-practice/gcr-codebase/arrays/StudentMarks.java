import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        // 2D array to store marks for Physics, Chemistry, and Maths
        int[][] marks = new int[n][3];
        double[] percentage = new double[n];
        String[] grade = new String[n];

        // Input marks for each student
        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                int mark;
                do {
                    System.out.print(subject + ": ");
                    mark = sc.nextInt();
                    if (mark < 0 || mark > 100) {
                        System.out.println("Invalid input! Marks should be between 0 and 100.");
                    }
                } while (mark < 0 || mark > 100);
                marks[i][j] = mark;
            }
        }

        // Calculate percentage and grade
        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 90)
                grade[i] = "A";
            else if (percentage[i] >= 80)
                grade[i] = "B";
            else if (percentage[i] >= 70)
                grade[i] = "C";
            else if (percentage[i] >= 60)
                grade[i] = "D";
            else
                grade[i] = "F";
        }

        // Display results
        System.out.println("\nStudent Results:");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + " - Percentage: " + percentage[i] + "%, Grade: " + grade[i]);
        }

        sc.close();
    }
}
