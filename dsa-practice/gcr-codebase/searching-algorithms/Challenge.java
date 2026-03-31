import java.util.Arrays;

public class Challenge {

    static int firstMissingPositive(int[] arr) {
        boolean[] present = new boolean[arr.length + 1];

        for (int num : arr) {
            if (num > 0 && num <= arr.length) {
                present[num] = true;
            }
        }

        for (int i = 1; i <= arr.length; i++) {
            if (!present[i]) return i;
        }
        return arr.length + 1;
    }

    static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(arr)); 
        System.out.println(binarySearch(arr, 4)); 
    }
}
