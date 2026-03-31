import java.util.*;
public class RotateNonNegativeElements {
    public static int[] rotateElements(int[] nums, int k) {
        ArrayList<Integer> list= new ArrayList();
        for(int i=0; i<nums.length; i++){
            if(nums[i] >= 0){
                list.add(nums[i]);
            }
        }
        if(list.size() == 0) return nums;

        k = k % list.size();
        int l = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] >= 0){
                nums[i] = list.get((l+k)%list.size());
                l++;
            }
        }
        return nums;
    }
    public static void main(String [] args){
        int [] nums = {1,-2,3,-1};
        int k=3;
        System.out.println(Arrays.toString(rotateElements(nums, k)));
    }
}