import java.util.*;
public class FindPeakElement {
    public int findPeakElement(int[] nums) {

        int len = nums.length;
        int idx = 0 ;

        for(int i = 0 ; i<len ; i++){
            
            if(nums[i] > nums[idx] ){
                idx = i ;
            }

        }
    return idx;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        FindPeakElement solution = new FindPeakElement();
        int result = solution.findPeakElement(nums);
        System.out.println("Index of a peak element: " + result);
        
    }
}
