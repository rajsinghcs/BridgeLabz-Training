import java.util.Arrays;
public class TwoBestNonOverlappingEvents {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));
        int n = events.length;
        int[] maxValue = new int[n];
        maxValue[0] = events[0][2]; 
        for (int i = 1; i < n; i++) {
            maxValue[i] = Math.max(maxValue[i - 1], events[i][2]);
        }
        int maxResult = 0;
        for (int i = 0; i < n; i++) {
            int startTime = events[i][0];
            int value = events[i][2];
            int left = 0, right = i - 1, bestIndex = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (events[mid][1] < startTime) {
                    bestIndex = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            int nonOverlappingValue = (bestIndex != -1) ? maxValue[bestIndex] : 0;
            maxResult = Math.max(maxResult, value + nonOverlappingValue);
        }
        return maxResult;
    }
    public static void main(String[] args){
        TwoBestNonOverlappingEvents tb = new TwoBestNonOverlappingEvents();
        int [][] events = {{1,3,2},{4,5,2},{2,4,3}};
        int result = tb.maxTwoEvents(events);
        System.out.println(result);
    }
}