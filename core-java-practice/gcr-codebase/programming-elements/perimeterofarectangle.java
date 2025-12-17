import java.util.*;
public class perimeterofarectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of rectangle:");
        double l = sc.nextDouble();
        System.out.println("Enter the breadth of rectangle:");
        double b = sc.nextDouble();
        double perimeter = 2 * (l + b);
        System.out.println("Perimeter of a rectangle is: " + perimeter);
    }
}