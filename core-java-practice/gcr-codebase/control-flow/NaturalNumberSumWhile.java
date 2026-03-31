package ControlFlows;


import java.util.Scanner;

public class NaturalNumberSumWhile {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     int number = sc.nextInt();

     if (number >= 0) {
         int sumUsingFormula = number * (number + 1) / 2;
         int sumUsingLoop = 0;
         int i = 1;

         while (i <= number) {
             sumUsingLoop += i;
             i++;
         }

         System.out.println("Sum using formula: " + sumUsingFormula);
         System.out.println("Sum using loop: " + sumUsingLoop);
     } else {
         System.out.println("Not a natural number");
     }

     sc.close();
 }
}

