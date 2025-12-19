import java.util.*;
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length == 0){
            return "";
        }
        int minlength = Integer.MAX_VALUE;
        for(String str : strs){
            minlength = Math.min (minlength, str.length());
        }
        for(int i=0 ; i<minlength ; i++){
            char ch = strs[0].charAt(i);
            
            for(int j=1 ; j<strs.length ; j++){
                if( i >= strs[j].length() || strs[j].charAt(i) != ch){
                    return strs[0].substring(0, i);

                }
            }
        }
        return strs[0].substring(0, minlength);
    }
    public static void main(String args[]){
        longestCommonPrefix sol = new longestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
        System.out.println(sol.longestCommonPrefix(strs)); 
    }
}
