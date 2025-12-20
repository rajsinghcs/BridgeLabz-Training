import java.util.Scanner;

public class StudentGrading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n;
        while (true) {
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n > 0) {
                    break;
                } else {
                    System.out.print("Please enter a positive number of students: ");
                }
            } else {
                System.out.print("Invalid input. Enter number of students: ");
                sc.next(); // discard
            }
        }

        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        // Input marks for each student
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ":");

            physics[i] = readPositiveMark(sc, "  Physics: ");
            chemistry[i] = readPositiveMark(sc, "  Chemistry: ");
            maths[i] = readPositiveMark(sc, "  Maths: ");

            int total = physics[i] + chemistry[i] + maths[i];
            percentage[i] = total / 3.0; // simple average to represent percentage
            grade[i] = determineGrade(percentage[i]);
        }

        // Display results
        System.out.println();
        System.out.println("Student\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t%d\t%d\t\t%d\t%.2f\t\t%c%n",
                    i + 1, physics[i], chemistry[i], maths[i], percentage[i], grade[i]);
        }

        sc.close();
    }

    // Helper to read a positive mark (0-100). If negative, asks again and retries
    // same index
    private static int readPositiveMark(Scanner sc, String prompt) {
        int mark;
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                mark = sc.nextInt();
                if (mark >= 0 && mark <= 100) {
                    return mark;
                } else {
                    System.out.println("  Mark must be between 0 and 100. Please re-enter.");
                }
            } else {
                System.out.println("  Invalid input. Please enter an integer between 0 and 100.");
                sc.next(); // discard non-integer
            }
        }
    }

    // Determine grade from percentage
    private static char determineGrade(double percent) {
        if (percent >= 80)
            return 'A';
        else if (percent >= 70)
            return 'B';
        else if (percent >= 60)
            return 'C';
        else if (percent >= 50)
            return 'D';
        else if (percent >= 40)
            return 'E';
        else
            return 'R';
    }
}