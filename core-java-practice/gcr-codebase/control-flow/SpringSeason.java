package ControlFlows;

public class SpringSeason {

 public static void main(String[] args) {

     int month = Integer.parseInt(args[0]);
     int day = Integer.parseInt(args[1]);

     // Check Spring Season condition
     boolean isSpring = (month == 3 && day >= 20) ||
                        (month == 4) ||
                        (month == 5) ||
                        (month == 6 && day <= 20);

     // Print result
     if (isSpring) {
         System.out.println("Its a Spring Season");
     } else {
         System.out.println("Not a Spring Season");
     }
 }
}

