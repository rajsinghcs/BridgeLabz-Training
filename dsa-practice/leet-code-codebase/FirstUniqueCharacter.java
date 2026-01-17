import java.util.*;
public class FirstUniqueCharacter {  
    public static int firstUniqChar(String s) {  
        for (int i = 0; i < s.length(); i++) {  
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {  
                return i;
            }  
        }  
        return -1;  
    } 
    public static void main(String [] args){
        String s = "leetcode";
        int i = firstUniqChar(s) ;
       
        System.out.println(i);

    } 
}