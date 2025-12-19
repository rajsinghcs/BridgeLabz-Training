import java.util.*;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n > 0 && (n & n - 1) == 0) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PowerOfTwo sol = new PowerOfTwo();
        System.out.println(sol.isPowerOfTwo(n));

    }
}