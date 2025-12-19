import java.util.*;
public class SortColors {
    public void sortColors(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(nums[j] > nums[j+1]){
                    int temp= nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]= temp ;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println("Original array: " + Arrays.toString(nums));
        sortColors solution = new sortColors();
        solution.sortColors(nums);
        System.out.println("Sorted array: " + Arrays.toString(nums));
    }
}
