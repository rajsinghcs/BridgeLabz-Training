package ControlFlows;

//Create class NaturalNumberSumFor
import java.util.Scanner;

class NaturalNumberSumFor {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     int number = sc.nextInt();

     if (number >= 0) {
         int sumUsingFormula = number * (number + 1) / 2;
         int sumUsingLoop = 0;

         for (int i = 1; i <= number; i++) {
             sumUsingLoop += i;
         }

         System.out.println("Sum using formula: " + sumUsingFormula);
         System.out.println("Sum using loop: " + sumUsingLoop);
     } else {
         System.out.println("Not a natural number");
     }

     sc.close();
 }
}

