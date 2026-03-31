import java.util.*;
public class AppleRedistributionIntoBoxes {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int total_apple = 0;
        for(int i=0; i<apple.length; i++){
            total_apple += apple[i];
        }
        Arrays.sort(capacity);
        int counter = 0;
        int total_capacity = 0;
        for(int i=capacity.length-1; i>=0; i--){
            total_capacity += capacity[i];
            counter++;
            if(total_capacity >= total_apple){
                return counter;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        AppleRedistributionIntoBoxes ab = new AppleRedistributionIntoBoxes();   
        int n = sc.nextInt();
        int[] apple = new int[n];

        for(int i=0; i<n; i++){
            apple[i] = sc.nextInt();
        }
        int[] capacity = new int[n];
        for(int i=0; i<n; i++){
            capacity[i] = sc.nextInt();
        }
        int result = ab.minimumBoxes(apple, capacity);
        System.out.println(result);
        sc.close();
    }
}