import java.util.*;
public class gasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int current = 0;
        int totalCost = 0;
        int position = -1;
        for(int i=0; i<gas.length; i++){
            int difference = gas[i] - cost[i];
            current += difference;
            totalCost += difference;
            if(current < 0){
                current = 0;
                position = i;
            }
        }
        if(totalCost >= 0){
            return position+1;
        } 
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] gas = new int[n]; 
        int[] cost = new int[n];
        for(int i=0; i<n; i++){
            gas[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            cost[i] = sc.nextInt();
        }
        gasStation solution = new gasStation();
        int result = solution.canCompleteCircuit(gas, cost);
        System.out.println("Starting gas station index: " + result);
        
    }
}