import java.util.*;
public class FactorOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to find its factors:");
        int number = sc.nextInt();
        if(number>0){
            System.out.println("Factors of " + number + " are:");
            for(int i=1; i<=number; i++){
                if(number % i == 0){
                    System.out.println(i);
                }
            }
        }
        else{
            System.out.println("Please enter a positive number");
        }
    }
}
