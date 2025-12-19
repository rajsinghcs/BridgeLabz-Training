package ControlFlows;


import java.util.Scanner;
public class NumberSignChecker {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     // Take number input
     int number = sc.nextInt();

     // Check sign of number
     if (number > 0) {
         System.out.println("Positive");
     } else if (number < 0) {
         System.out.println("Negative");
     } else {
         System.out.println("Zero");
     }

     sc.close();
 }
}
