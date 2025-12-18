import java.util.*;
public class  MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int n = nums.length / 2;
        for (int i : map.keySet()) {
            if (map.get(i) > n) {
                return i;
            }
        }
        return -1;
    }

    // Main method with user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = sc.nextInt();

        int[] nums = new int[size];
        System.out.println("Enter array elements:");
        for (int i = 0; i < size; i++) {
            nums[i] = sc.nextInt();
        }

        MajorityElement obj = new MajorityElement();
        int result = obj.majorityElement(nums);

        if (result != -1) {
            System.out.println("Majority Element: " + result);
        } else {
            System.out.println("No majority element found");
        }

        sc.close();
    }
}
