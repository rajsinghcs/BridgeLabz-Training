import java.util.*;
class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int spointer = 0;
        int tpointer = 0;
        while(spointer < s.length() && tpointer < t.length()){
            if(s.charAt(spointer) == t.charAt(tpointer)){
                spointer++;
            }
            tpointer++;
        }
        return spointer == s.length(); 
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        IsSubsequence obj = new IsSubsequence();
        boolean result = obj.isSubsequence(s, t);
        System.out.println(result);
        sc.close();
    }
}