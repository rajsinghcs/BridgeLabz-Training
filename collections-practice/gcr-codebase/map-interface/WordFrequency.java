import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        String text = "Hello world, hello Java!";

        Map<String, Integer> map = new HashMap<>();

        text = text.toLowerCase().replaceAll("[^a-z ]", "");
        String[] words = text.split("\\s+");

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        System.out.println(map);
    }
}
