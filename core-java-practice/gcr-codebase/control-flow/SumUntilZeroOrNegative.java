package ControlFlows;

import java.util.Scanner;

class SumUntilZeroOrNegative {

 public static void main(String[] args) {
     // Create Scanner object
     Scanner sc = new Scanner(System.in);

     // Initialize sum
     double total = 0.0;

     // Infinite loop
     while (true) {
         double value = sc.nextDouble();

         // Break condition
         if (value <= 0) {
             break;
         }

         total += value;
     }

     // Print result
     System.out.println("Total sum is " + total);

     // Close Scanner
     sc.close();
 }
}

