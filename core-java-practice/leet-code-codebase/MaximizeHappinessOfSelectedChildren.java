import java.util.*;
public class MaximizeHappinessOfSelectedChildren {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);        
        long score = 0;
        int n = happiness.length;
        
        for (int i = 0; i < k; i++) {
            long currentVal = happiness[n - 1 - i] - i;
            if (currentVal > 0) {
                score += currentVal;
            } else {
                break; 
            }
        }
        return score;
    }
    public static void main(String[] args) {
        MaximizeHappinessOfSelectedChildren mhsc = new MaximizeHappinessOfSelectedChildren();
        int[] happiness = {4, 3, 1, 2, 5};
        int k = 3;
        long result = mhsc.maximumHappinessSum(happiness, k);
        System.out.println("Maximum Happiness Sum: " + result);
    }
}