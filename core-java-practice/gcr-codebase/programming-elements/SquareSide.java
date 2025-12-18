import java.util.Scanner;

public class SquareSide {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter the perimeter of the square: ");
        double perimeter = sc.nextDouble();

        // Calculating side
        double side = perimeter / 4;

        // Printing output (same format as required)
        System.out.println(
            "The length of the side is " + side +
            " whose perimeter is " + perimeter
        );
    }
}
