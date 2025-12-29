import java.util.Scanner;

public class MovieTicketBookingApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char choice = 'y'; // ✅ initialized to avoid compilation error

        do {
            int totalCost = 0;

            System.out.print("Enter movie type (1-Regular, 2-3D): ");
            int movieType = sc.nextInt();

            switch (movieType) {
                case 1:
                    totalCost += 150;
                    break;
                case 2:
                    totalCost += 250;
                    break;
                default:
                    System.out.println("Invalid movie type");
                    continue;
            }

            System.out.print("Enter seat type (Gold/Silver): ");
            String seatType = sc.next();

            if (seatType.equalsIgnoreCase("Gold")) {
                totalCost += 100;
            } else if (seatType.equalsIgnoreCase("Silver")) {
                totalCost += 50;
            } else {
                System.out.println("Invalid seat type");
                continue;
            }

            System.out.print("Add snacks? (yes/no): ");
            String snacks = sc.next();

            if (snacks.equalsIgnoreCase("yes")) {
                totalCost += 80;
            }

            System.out.println("Total Ticket Cost: ₹" + totalCost);

            System.out.print("Next customer? (y/n): ");
            choice = sc.next().charAt(0);

        } while (choice == 'y' || choice == 'Y');

        sc.close();
    }
}
