import java.util.*;

public class BusRouteDistanceTracker {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int totalDistance = 0;

        while (true) {
            System.out.print("Enter distance for next stop (in km): ");
            int distance = sc.nextInt();

            totalDistance += distance;
            System.out.println("Total distance covered: " + totalDistance + " km");

            System.out.print("Do you want to get off? (yes/no): ");
            String choice = sc.next();

            if (choice.equalsIgnoreCase("yes")) {
                System.out.println("Passenger got off. Final distance: " + totalDistance + " km");
                break;
            }
        }
    }
}
