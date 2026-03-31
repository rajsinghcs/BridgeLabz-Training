import java.util.*;
import java.io.*;

public class ArrayOperation {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int [] arr ;
        try{
            int size = sc.nextInt();
            int idx = sc.nextInt();
            arr = new int[size];
            for(int i=0;i<size; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(arr[idx]);
        
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid Index!");
        }catch(NullPointerException e){
            System.out.println("Array is not initialized!");
        }
    }
}
