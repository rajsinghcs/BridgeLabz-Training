import java.util.*;

public class VoteEligibility {
    public static void main(String agrs[]) {
        Scanner sc = new Scanner(System.in);

        // Ask user for the number of students
        System.out.println("Enter the number of students:");
        int n = sc.nextInt();

        // Array to store ages of students
        int[] student_age = new int[n];
        // Input ages of all students
        for (int i = 0; i < student_age.length; i++) {
            student_age[i] = sc.nextInt();
        }

        // Check voting eligibility for each student
        for (int i = 0; i < student_age.length; i++) {
            if (student_age[i] < 0) {
                System.out.println("Invalid age");
            } else if (student_age[i] >= 18) {
                System.out.println("The student with the age " + student_age[i] + " can vote");
            } else {
                System.out.println("The student with the age " + student_age[i] + " cannot vote.");
            }
        }

    }
}
