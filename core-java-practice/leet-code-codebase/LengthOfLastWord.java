import java.util.*;
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s.length() ==1){
            return s.length();
    }
    int counter=0;
    String t = s.trim();
    for(int i=t.length()-1; i>=0; i--){
        if(t.charAt(i) == ' '){
           break;
        }
        else{
            counter++;
        }
    }
        return counter;
    }
    public static void main(String args[]){
        lengthOfLastWord sol = new lengthOfLastWord();
        String s = "Hello World";
        System.out.println(sol.lengthOfLastWord(s)); 
    }
}
