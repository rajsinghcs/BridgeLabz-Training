package ControlFlows;


import java.util.Scanner;

class RocketLaunchFor {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     // Take input
     int counter = sc.nextInt();

     // Countdown using for loop
     for (int i = counter; i >= 1; i--) {
         System.out.println(i);
     }

     // Close Scanner
     sc.close();
 }
}

