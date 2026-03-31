import java.util.*;
public class MinimumPairRemovalToSortArray1{
    public static boolean sorted(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    public static int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums){
            list.add(n);
        }

        int count = 0;
        while (!sorted(list)) {

            int minSum = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }
            list.set(idx, list.get(idx) + list.get(idx + 1));
            list.remove(idx + 1);
            count++;
        }
        return count;
    }
    public static void main(String[] args){
        int nums [] = {5,2,3,1};
        System.out.println(minimumPairRemoval(nums));
    }
}
