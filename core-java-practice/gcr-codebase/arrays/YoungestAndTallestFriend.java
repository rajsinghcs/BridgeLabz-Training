import java.util.Scanner;

public class YoungestAndTallestFriend {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Names of the friends
        String[] friends = { "Amar", "Akbar", "Anthony" };

        // Arrays to store age and height for each friend
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Input age and height for each friend
        System.out.println("Enter age and height for 3 friends:");
        for (int i = 0; i < friends.length; i++) {
            System.out.println("\n" + friends[i]);

            System.out.print("Age: ");
            ages[i] = scanner.nextInt();

            System.out.print("Height (in cm): ");
            heights[i] = scanner.nextDouble();
        }

        // Initialize indices assuming first friend is youngest and tallest
        int youngestIndex = 0;
        int tallestIndex = 0;

        // Determine youngest and tallest friend
        for (int i = 1; i < friends.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // Display the results
        System.out.println("\nResults:");
        System.out.println("Youngest Friend: " + friends[youngestIndex] +
                " (Age: " + ages[youngestIndex] + ")");
        System.out.println("Tallest Friend: " + friends[tallestIndex] +
                " (Height: " + heights[tallestIndex] + " cm)");

        scanner.close();
    }
}
