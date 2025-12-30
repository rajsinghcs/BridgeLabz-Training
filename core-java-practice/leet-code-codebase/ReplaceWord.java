import java.util.*;
public class ReplaceWord {
    public String replaceWords(List<String> dictionary, String sentence) {
        String [] sen = sentence.split("\\s+");
        for(int i=0; i<sen.length; i++){
            String s1 = sen[i];
            String s2 = s1;
            for(int j=0; j<dictionary.size(); j++){
                String root = dictionary.get(j);
                if(s1.startsWith(root)){
                    if(s2.length() > root.length()){
                        s2 = root;
                    }
                }
            }
            sen[i] = s2;
        }
        return String.join(" ",sen);
    }
    public static void main(String[] args) {
        ReplaceWord rw = new ReplaceWord();
        List<String> dict = Arrays.asList("cat","bat","rat");
        String sentence = "the cattle was rattled by the battery";
        String result = rw.replaceWords(dict, sentence);
        System.out.println(result);
    }
}