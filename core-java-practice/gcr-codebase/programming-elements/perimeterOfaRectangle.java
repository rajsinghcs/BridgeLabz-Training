import java.util.*;
public class perimeterOfaRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length of the rectangle: ");
        double length = scanner.nextDouble();

        System.out.print("Enter breadth of the rectangle: ");
        double breadth = scanner.nextDouble();

        double perimeter = 2 * (length + breadth);

        System.out.println(perimeter);
    }
}