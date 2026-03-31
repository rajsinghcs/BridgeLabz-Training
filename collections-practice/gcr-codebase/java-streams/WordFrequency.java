import java.io.*;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("input.txt"));
            String line;
            Map<String, Integer> wordCount = new HashMap<>();

            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.isEmpty()) continue; 
                    word = word.toLowerCase();    
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }

            // Sort entries by frequency in descending order
            List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());
            list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            System.out.println("Total words: " + wordCount.size());
            System.out.println("Top 5 most frequent words:");
            for (int i = 0; i < Math.min(5, list.size()); i++) {
                Map.Entry<String, Integer> entry = list.get(i);
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("IO Error occurred: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                System.out.println("Error closing file");
            }
        }
    }
}
