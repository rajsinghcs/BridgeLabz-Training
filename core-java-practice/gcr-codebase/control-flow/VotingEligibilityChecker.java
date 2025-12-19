package ControlFlows;

import java.util.Scanner;

class VotingEligibilityChecker {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     // Take age input
     int age = sc.nextInt();

     // Check voting eligibility
     if (age >= 18) {
         System.out.println("The person's age is " + age + " and can vote.");
     } else {
         System.out.println("The person's age is " + age + " and cannot vote.");
     }
     sc.close();
 }
}
