import java.util.*;
public class DeleteColumnstoMakeSorted {
    public int minDeletionSize(String[] s) {
        int n = s.length, m = s[0].length();
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int row = 1; row < n; row++) {
                if (s[row].charAt(i) < s[row - 1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next();
        }
        DeleteColumnstoMakeSorted obj = new DeleteColumnstoMakeSorted();
        int result = obj.minDeletionSize(strs);
        System.out.println(result);
    }
}
