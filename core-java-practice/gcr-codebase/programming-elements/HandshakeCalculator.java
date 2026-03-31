import java.util.Scanner;

public class HandshakeCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter number of students: ");
        int numberOfStudents = sc.nextInt();

        // Calculating maximum handshakes
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        // Displaying result
        System.out.println(
            "The maximum number of possible handshakes is " + handshakes
        );
    }
}
