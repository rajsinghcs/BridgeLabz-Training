import java.util.*;
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int counter = 0;

        for(int i=0; i<nums.length; i++){
            if( nums[i] != 0){
                nums[counter] = nums[i];
                counter++;
            }
        }
        for(int i=counter; i<nums.length; i++){
            nums[i] = 0;
        }
    }
    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int[] arr = {0,1,0,3,12};
        mz.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}