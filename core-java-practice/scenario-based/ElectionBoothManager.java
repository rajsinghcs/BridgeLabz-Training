import java.util.Scanner;

public class ElectionBoothManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Variables to store votes for each candidate
        int voteCount1 = 0;
        int voteCount2 = 0;
        int voteCount3 = 0;

        // Loop runs until the user enters the exit code
        while (true) {
            System.out.print("\nEnter age (or -1 to stop voting): ");
            int age = sc.nextInt();

            // Stop accepting voters when -1 is entered
            if (age == -1) {
                break;
            }

            // Check voting eligibility
            if (age < 18) {
                System.out.println("Not eligible to vote.");
                continue; // move to next voter
            }

            // Eligible voter can cast a vote
            System.out.println("Eligible to vote.");
            System.out.print("Cast your vote (1 / 2 / 3): ");
            int vote = sc.nextInt();

            // Record vote based on candidate number
            if (vote == 1) {
                voteCount1++;
            } else if (vote == 2) {
                voteCount2++;
            } else if (vote == 3) {
                voteCount3++;
            } else {
                System.out.println("Invalid vote.");
            }
        }

        // Display final voting results
        System.out.println("\nVoting Results:");
        System.out.println("Candidate 1: " + voteCount1);
        System.out.println("Candidate 2: " + voteCount2);
        System.out.println("Candidate 3: " + voteCount3);

        sc.close();
    }
}
