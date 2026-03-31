import java.util.*;
public class Sqrt {
    public int mySqrt(int x) {

        if (x == 0 || x == 1) {
            return x;
        }

        long start = 1;
        int end = x;
        int result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;

            if (mid * mid == x) {
                return (int) mid;
            }

            if (mid * mid < x) {
                start = mid + 1;
                result = (int) mid;
            } else {
                end = (int) mid - 1;
            }
        }

        return result;
    }

    // Main method with user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a non-negative number: ");
        int x = sc.nextInt();

        Sqrt obj = new Sqrt();
        int sqrt = obj.mySqrt(x);

        System.out.println("Square root (integer part): " + sqrt);

        sc.close();
    }
}
