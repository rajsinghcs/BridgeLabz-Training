import java.util.Scanner;
public class volumeOfacylinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius of cylinder:");
        double r = sc.nextDouble();
        System.out.println("Enter the height of cylinder:");
        double h = sc.nextDouble();
        double volume = Math.PI * r * r * h;
        System.out.println("Volume of a cylinder is: " + volume);
    }
}