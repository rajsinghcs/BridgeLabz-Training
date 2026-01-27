import java.util.*;
import java.io.*;
public class CalculateInterest {
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException{
        if(amount < 0 || rate < 0){
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        return (rate*amount*years)/100;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            int years = sc.nextInt();
            double amount = sc.nextDouble();
            double rate = sc.nextDouble();
            System.out.println(calculateInterest(amount, rate, years));
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
