import java.util.*;
public class UglyNumber {
    public boolean isUgly(int n) {
        if (n <= 0) return false; 

        int[] primes = {2, 3, 5};

        for (int p : primes) {
            while (n % p == 0) {
                n /= p;
            }
        }

        return n == 1;
    }
    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean result = uglyNumber.isUgly(num);
        System.out.println(result ? "Ugly Number" : "Not an Ugly Number");
        sc.close();
    }
}