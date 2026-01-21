import java.util.*;
public class MinimumStringLengthAfterRemovingSubstrings {
    public static int minLength(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder str = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            if(!st.isEmpty()){
                if((s.charAt(i)=='B' && st.peek() =='A') || (s.charAt(i)=='D' && st.peek()=='C')){
                st.pop();
                }else{
                    st.push(s.charAt(i));
                }
            }else{
                st.push(s.charAt(i));
            }
        }
        for(char ch : st){
            str.append(ch);
        }
        return str.length();
    }
    public static void main(String[] args){
        String s = "ABFCACDB";
        System.out.println(minLength(s));
    }
}