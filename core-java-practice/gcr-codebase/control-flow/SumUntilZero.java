package ControlFlows;

import java.util.Scanner;

class SumUntilZero {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     double total = 0.0;
     double value;

     // Loop until user enters 0
     while (true) {
         value = sc.nextDouble();
         if (value == 0) {
             break;
         }
         total += value;
     }

     // Print total
     System.out.println("Total sum is " + total);

     // Close Scanner
     sc.close();
 }
}

