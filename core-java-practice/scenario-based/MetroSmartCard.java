import java.util.Scanner;

public class MetroSmartCard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double balance = 200.0; // initial balance

        while (balance > 0) {
            System.out.println("\nCurrent Balance: ₹" + balance);
            System.out.print("Enter distance in km (or -1 to exit): ");
            int distance = sc.nextInt();

            if (distance == -1) {
                break;
            }

            // Fare calculation using ternary operator
            double fare = (distance <= 5) ? 10 :
                          (distance <= 15) ? 20 : 30;

            if (fare > balance) {
                System.out.println("Insufficient balance.");
                break;
            }

            balance -= fare;
            System.out.println("Fare deducted: ₹" + fare);
        }

        System.out.println("\nThank you for using Delhi Metro.");
        sc.close();
    }
}
