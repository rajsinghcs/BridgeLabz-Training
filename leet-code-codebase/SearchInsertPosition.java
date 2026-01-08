import java.util.*;
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
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
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int result = searchInsert(nums, target);
        System.out.println("The target should be inserted at index: " + result);
       
    }
}