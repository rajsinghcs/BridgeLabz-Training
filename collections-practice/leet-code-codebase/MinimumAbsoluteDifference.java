import java.util.*;
public class MinimumAbsoluteDifference {
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;
        int diff;
        for (int i = 1; i < n; i++) {
            diff = arr[i] - arr[i - 1];
            if (diff < min) {
                res.clear();
                min = diff;
                res.add(new ArrayList(Arrays.asList(arr[i - 1], arr[i])));
            } else if (diff == min) {
                res.add(new ArrayList(Arrays.asList(arr[i - 1], arr[i])));
            }
        }
        return res;
    }
    public static void main(String [] args){
        int [] arr = {4,2,1,3};
        System.out.println(minimumAbsDifference(arr));
    }
}