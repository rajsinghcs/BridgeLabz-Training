import java.util.*;
public class FourDivisor {
    public int sumFourDivisors(int[] nums) {
        int totalSum = 0;

        // Loop through each number in the array
        for (int num : nums) {
            int cntDivisor = 0;
            int divisorSum = 0;

            // Only iterate till sqrt(num)
            for (int i = 1; i * i <= num; i++) {
                if (num % i == 0) {
                    int d1 = i;
                    int d2 = num / i;

                    if (d1 == d2) {
                        cntDivisor++;
                        divisorSum += d1;
                    } else {
                        cntDivisor += 2;
                        divisorSum += d1 + d2;
                    }

                    // Early break if more than 4 divisors
                    if (cntDivisor > 4) break;
                }
            }

            // Add sum only if exactly 4 divisors exist
            if (cntDivisor == 4) {
                totalSum += divisorSum;
            }
        }
        return totalSum;
    }
    public static void main(String[] args) {
        FourDivisor fd = new FourDivisor();
        int[] nums = {21, 4, 7};
        System.out.println(fd.sumFourDivisors(nums)); // Output: 32
    }
}
