import java.util.*;
public class ProfitAndLoss {
    public static void main(String args[]){
        int costPrice = 129;
        int sellingPrice = 191;
        int profit = sellingPrice - costPrice;
        int profitPercentage = (profit * 100) / costPrice;
        System.out.println("The Cost Price is INR: " + costPrice + " and " +"Selling Price is: " + sellingPrice);
        System.out.println("The Profit is INR: " + profit + " and " +"The Profit Percentage is: " + profitPercentage + "%");
    }
}
