package ControlFlows;

import java.util.Scanner;

class DivisibleByFiveChecker {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     // Get integer input from user
     int number = sc.nextInt();

     // Check divisibility by 5
     boolean isDivisibleByFive = (number % 5 == 0);

     // Print result
     System.out.println("Is the number " + number + " divisible by 5? " + isDivisibleByFive);
     sc.close();
 }
}
