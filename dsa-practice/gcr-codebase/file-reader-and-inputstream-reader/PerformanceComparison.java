import java.io.*;
import java.nio.charset.StandardCharsets;

public class PerformanceComparison {

    public static void main(String[] args) throws Exception {

        
        // 1. StringBuilder vs StringBuffer
        int iterations = 1_000_000;
        String word = "hello";

        // StringBuilder
        long startSB = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(word);
        }
        long endSB = System.nanoTime();

        // StringBuffer
        long startSBuf = System.nanoTime();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbuf.append(word);
        }
        long endSBuf = System.nanoTime();

        System.out.println("StringBuilder Time (ms): " + (endSB - startSB) / 1_000_000);
        System.out.println("StringBuffer Time (ms): " + (endSBuf - startSBuf) / 1_000_000);

        
        // 2. FileReader vs InputStreamReader
        File file = new File("largefile.txt"); // ~100MB text file

        // FileReader
        long startFR = System.nanoTime();
        long wordCountFR = countWordsUsingFileReader(file);
        long endFR = System.nanoTime();

        // InputStreamReader
        long startISR = System.nanoTime();
        long wordCountISR = countWordsUsingInputStreamReader(file);
        long endISR = System.nanoTime();

        System.out.println("\nFileReader Word Count: " + wordCountFR);
        System.out.println("FileReader Time (ms): " + (endFR - startFR) / 1_000_000);

        System.out.println("\nInputStreamReader Word Count: " + wordCountISR);
        System.out.println("InputStreamReader Time (ms): " + (endISR - startISR) / 1_000_000);
    }

    // FileReader word count
    private static long countWordsUsingFileReader(File file) throws IOException {
        long count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.isEmpty()) {
                    count += words.length;
                }
            }
        }
        return count;
    }

   
    // InputStreamReader word count
    private static long countWordsUsingInputStreamReader(File file) throws IOException {
        long count = 0;
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.isEmpty()) {
                    count += words.length;
                }
            }
        }
        return count;
    }
}
