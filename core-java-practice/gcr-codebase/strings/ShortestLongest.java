import java.util.Scanner;

public class ShortestLongest {

    static int lengthWithoutLength(String s) {
        int c = 0;
        try {
            while (true) s.charAt(c++);
        } catch (Exception e) {
            return c;
        }
    }

    static int[] shortestLongest(String[] words) {
        int min = Integer.MAX_VALUE, max = 0;
        for (String w : words) {
            int len = lengthWithoutLength(w);
            if (len < min) min = len;
            if (len > max) max = len;
        }
        return new int[]{min, max};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = text.split(" ");

        int[] result = shortestLongest(words);
        System.out.println("Shortest length: " + result[0]);
        System.out.println("Longest length: " + result[1]);
        sc.close();
    }
}

