import java.util.*;
public class searchInsertposition {
    public int searchInsert(int[] nums, int target) {
        int x = nums.length;

        
        for (int i = 0; i < x; i++) {
            if (nums[i] == target) {
                return i; 
            }
        }

    
        for (int i = 0; i < x; i++) {
            if (nums[i] > target) {
                return i; 
            }
        }
        
        return x;
    }
    public static void main(String args[]){
        searchInsertposition sol = new searchInsertposition();
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(sol.searchInsert(nums, target)); 
    }
}