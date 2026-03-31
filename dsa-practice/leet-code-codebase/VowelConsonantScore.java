import java.util.*;
public class VowelConsonantScore {
    public static int vowelConsonantScore(String s) {
        String v = "aeiou";
        double vcounter=0;
        double ccounter=0;
        for(int i=0; i<s.length(); i++){
            if(Character.isLetter(s.charAt(i))){
                if(v.indexOf(s.charAt(i)) != -1){
                    vcounter++;
                }else{
                    ccounter++;
                }
            }
        }
        if(ccounter>0){
            return (int) Math.floor( vcounter/ccounter);
        }
        return 0;
    }
    public static void main(String [] args){
        String s = "cooear";
        System.out.println(vowelConsonantScore(s));
    }
}

