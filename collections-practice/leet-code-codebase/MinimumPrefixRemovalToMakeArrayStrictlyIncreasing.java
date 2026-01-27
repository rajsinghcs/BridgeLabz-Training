import java.util.*;
public class MinimumPrefixRemovalToMakeArrayStrictlyIncreasing {
    public static int minimumPrefixLength(int[] nums) {
        int cnt = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] >= nums[i+1]){
                cnt = i+1;
            }
        }
        return cnt;
    }
    public static void main(String [] args){
        int [] nums = {1,-1,2,3,3,4,5};
        System.out.println(minimumPrefixLength(nums));
    }
}