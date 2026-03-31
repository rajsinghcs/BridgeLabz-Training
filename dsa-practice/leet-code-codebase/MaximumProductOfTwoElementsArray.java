import java.util.*;

public class MaximumProductOfTwoElementsArray {
    public static int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num >= max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }

    public static void main(String [] args){
        int [] nums = {1,5,4,5};
        System.out.println(maxProduct(nums)); 
    }
}
