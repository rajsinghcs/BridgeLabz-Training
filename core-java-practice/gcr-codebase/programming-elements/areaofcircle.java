import java.util.Scanner;
public class areaofcircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();
        
        //formula to calculate area of circle
        double area = Math.PI * radius * radius;
        System.out.println("The area of the circle is: " + area);
    }
}