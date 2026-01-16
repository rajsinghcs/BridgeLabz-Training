// Best Case - O(n) (already sorted array)
// Average Case - O(n^2)
// Worst Case - O(n^2) (reverse sorted array)
// Space - O(1) auxiliary space (in-place)

import java.util.*;
public class InsertionSort {

    public static void sortEmployeeId(int [] employee_ids){
        int len = employee_ids.length;

        for(int i=1; i<len; i++){
            int j = i-1;
            int key = employee_ids[i];

            while(j >= 0 && employee_ids[j] > key){
                employee_ids[j+1] = employee_ids[j];
                j--;
            }
            employee_ids[j+1] = key;
        }
    }
    public static void main(String [] args){
        int [] employee_ids = {762, 877, 987, 365, 333, 291, 980};
        sortEmployeeId(employee_ids);
        System.out.println(Arrays.toString(employee_ids));
    }
}
