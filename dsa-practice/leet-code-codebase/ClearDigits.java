import java.util.*;
public class ClearDigits {
    public static String clearDigits(String s) {
        Stack<Character> st = new Stack();

        for(int i=0; i<s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                st.push(s.charAt(i));
            }else if(Character.isDigit(s.charAt(i)) && !st.isEmpty()){
                st.pop();
            }
        }
        StringBuilder str = new StringBuilder();
        for(char ch : st){
            str.append(ch);
        }
        return str.toString();
    }
    public static void main(String[] args){
        String s = "we23";
        System.out.println(clearDigits(s));
    }
}