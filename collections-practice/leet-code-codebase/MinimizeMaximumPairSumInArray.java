import java.util.*;
public class MinimizeMaximumPairSumInArray {
    public static int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length-1;
        int maxSum = Integer.MIN_VALUE;

        while(left < right){
            maxSum = Math.max(maxSum, nums[left]+nums[right]);
            left++;
            right--;
        }
        return maxSum;
    }
    public static void main(String [] args){
        int nums [] = {3,5,2,3};
        System.out.println(minPairSum(nums));
    }
}