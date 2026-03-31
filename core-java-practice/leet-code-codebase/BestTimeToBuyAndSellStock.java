import java.util.Scanner;

 public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int maxPro = 0;
        int minSto = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minSto) {
                minSto = prices[i];
            }
            maxPro = Math.max(maxPro, prices[i] - minSto);
        }
        return maxPro;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();
        int profit = obj.maxProfit(prices);

        System.out.println("Maximum Profit: " + profit);

        sc.close();
    }
}
