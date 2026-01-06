public class MathematicalOperations {

    // Factorial
    static long factorial(int n) {
        if (n < 0) return -1;

        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Prime check
    static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // GCD (Euclidean Algorithm)
    static int gcd(int a, int b) {
        if (a < 0 || b < 0) return -1;

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Fibonacci 
    static int fibonacci(int n) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {

        // Testing edge cases
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Factorial of 0: " + factorial(0));
        System.out.println("Factorial of -3: " + factorial(-3));

        System.out.println("Is 7 Prime? " + isPrime(7));
        System.out.println("Is 1 Prime? " + isPrime(1));

        System.out.println("GCD of 24 and 36: " + gcd(24, 36));
        System.out.println("GCD with negative: " + gcd(-4, 8));

        System.out.println("Fibonacci(6): " + fibonacci(6));
        System.out.println("Fibonacci(0): " + fibonacci(0));
    }
}