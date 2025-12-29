import java.util.*;

public class RohanLibraryReminderApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Repeat for 5 books
        for (int i = 1; i <= 5; i++) {
            System.out.print("\nBook " + i + " - Enter due date (day): ");
            int dueDate = sc.nextInt();

            System.out.print("Enter return date (day): ");
            int returnDate = sc.nextInt();

            if (returnDate > dueDate) {
                int lateDays = returnDate - dueDate;
                int fine = lateDays * 5;
                System.out.println("Late by " + lateDays + " days. Fine: ₹" + fine);
            } else {
                System.out.println("Returned on time. No fine.");
            }
        }

        sc.close();
    }
}
