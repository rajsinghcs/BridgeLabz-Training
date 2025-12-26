import java.util.*;
class ReverseWordsInAString {  
    public String reverseWords(String s) {  
        s = " "+ s.trim();
        int n = s.length();
        String res = "";
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i) == ' '){
                if(i< n-1){
                res += s.substring(i+1, n) +" ";
            }
             n=i;
          }
        
        }
        return res.trim(); 
    } 
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ReverseWordsInAString obj = new ReverseWordsInAString();
        String result = obj.reverseWords(str);
        System.out.println(result);
    }
}