import java.util.*;

public class FestivalLuckyDraw {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 5; i++) {   // 5 visitors
            System.out.print("Visitor " + i + ", enter your number: ");
            int number = sc.nextInt();

            if (number <= 0) {
                System.out.println("Invalid input! Try next visitor.");
                continue;
            }

            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("🎁 Congratulations! You won a gift!");
            } else {
                System.out.println("Sorry, better luck next time.");
            }
        }
    }
}

