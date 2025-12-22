import java.util.*;
public class CountingBits{
    public int[] countBits(int n) {
        int [] arr = new int[n+1];
        for(int i=0; i<=n; i++){
            arr[i] = Integer.bitCount(i); 
        }
        return arr;
        
    }
    public static void main(String[] args){
        CountingBits cb = new CountingBits();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int [] result = cb.countBits(num);
        System.out.println(Arrays.toString(result));
        sc.close();
    }
}