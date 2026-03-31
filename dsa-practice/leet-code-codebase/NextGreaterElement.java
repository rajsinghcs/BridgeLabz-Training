import java.util.*;
public class NextGreaterElement{
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int nums [] = new int[n];

        for(int i=0; i<n; i++){
           int greaterIdx = -1;  

            for (int j = nums2.length - 1; j >= 0; j--) {  
                if (nums2[j] == nums1[i]) {  
                    break;  
                }  

                if (nums2[j] > nums1[i]) {  
                    greaterIdx = nums2[j];  
                }  
            }  
            nums[i] = greaterIdx;  
        }  

        return nums;  
    }  
    public static void main(String [] args){
        int [] nums1 = {4,1,2};
        int []  nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1,nums2)));
    }
}  