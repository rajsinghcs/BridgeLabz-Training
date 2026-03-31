import java.util.*;
import java.io.*;
public class TwoNumber {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        try{
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            double ans = num1/num2;
            System.out.println(ans);

        }catch(ArithmeticException e){
            System.out.println("Can not divide by 0");

        }catch(InputMismatchException e){
            System.out.println("Enter only numbers");
        }
    }
}
