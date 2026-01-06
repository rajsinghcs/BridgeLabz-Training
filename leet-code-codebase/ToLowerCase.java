import java.util.*;
public class ToLowerCase {
    public static String toLowerCase(String s) {
        return s.toLowerCase();
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter a string:");   
        String s = sc.nextLine(); 
        System.out.println(toLowerCase(s));
    }
}