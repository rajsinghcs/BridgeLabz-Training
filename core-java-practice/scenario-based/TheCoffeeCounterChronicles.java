import java.util.Scanner;
public class TheCoffeeCounterChronicles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double GST_RATE = 0.05; // 5% GST

        while (true) {
            System.out.println("\nEnter coffee type (Espresso / Latte / Cappuccino) or 'exit' to stop:");
            String coffeeType = scanner.nextLine().toLowerCase();

            if (coffeeType.equals("exit")) {
                System.out.println("Thank you for visiting Ravi's Cafe");
                break; // exit loop
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            double pricePerCup;

            switch (coffeeType) {
                case "espresso":
                    pricePerCup = 120;
                    break;
                case "latte":
                    pricePerCup = 150;
                    break;
                case "cappuccino":
                    pricePerCup = 180;
                    break;
                default:
                    System.out.println("Invalid coffee type!");
                    continue; // skip current iteration
            }

            double totalPrice = pricePerCup * quantity;
            double gstAmount = totalPrice * GST_RATE;
            double finalBill = totalPrice + gstAmount;

           System.out.println("Total Price: Rs. " + totalPrice);
           System.out.println("GST (5%): Rs. " + gstAmount);
           System.out.println("Final Bill: Rs. " + finalBill);

        }

        scanner.close();
    }
}
