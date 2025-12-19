package ControlFlows;

import java.util.Scanner;

class RocketLaunchWhile {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     // Take countdown input
     int counter = sc.nextInt();

     // Countdown using while loop
     while (counter >= 1) {
         System.out.println(counter);
         counter--;
     }

     // Close Scanner
     sc.close();
 }
}
