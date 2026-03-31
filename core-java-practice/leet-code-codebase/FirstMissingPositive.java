import java.util.*;

class FirstNissingPositive {

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int c = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == c) {
                c++;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        FirstNissingPositive obj = new FirstNissingPositive();
        int result = obj.firstMissingPositive(nums);

        System.out.println("First missing positive number: " + result);

        sc.close();
    }
}
