import java.util.*;

public class NumberCheck {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // array to store 5 integers
        int[] integer_array = new int[5];
        for (int i = 0; i < integer_array.length; i++) {
            integer_array[i] = sc.nextInt();
        }

        // Check each number and print its type
        for (int i = 0; i < integer_array.length; i++) {
            if (integer_array[i] == 0) {
                System.err.println("Zero");
            } else if (integer_array[i] < 0) {
                System.out.println("Negative");
            } else {
                if (integer_array[i] % 2 == 0) {
                    System.out.println("Positive Even number");
                } else {
                    System.out.println(" Positive Odd number");
                }
            }
        }

        // Compare first and last elements in the array
        if (integer_array[0] == integer_array[integer_array.length - 1]) {
            System.out.println("First and Last element are equal");
        } else if (integer_array[0] > integer_array[integer_array.length - 1]) {
            System.out.println("First element is greater than Last element");
        } else {
            System.out.println("First element is less than Last element");
        }
        sc.close();
    }
}
