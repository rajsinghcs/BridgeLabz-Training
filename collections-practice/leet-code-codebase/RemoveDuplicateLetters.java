import java.util.*;
class RemoveDuplicateLetters {
    public static String removeDuplicateLetter(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), i);
        }
        
        HashSet<Character> visited = new HashSet<>();
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(visited.contains(s.charAt(i))){
                continue;
            }
            while(!st.isEmpty() && map.get(st.peek()) > i && s.charAt(i) < st.peek()){
                visited.remove(st.pop());
            }
            st.push(s.charAt(i));
            visited.add(s.charAt(i));
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop());
        }
        return str.reverse().toString();
    }
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetter(s));
    }
}