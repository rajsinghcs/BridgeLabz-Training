import java.util.Scanner;

public class WordLength2D {

    static int lengthWithoutLength(String s) {
        int c = 0;
        try {
            while (true) s.charAt(c++);
        } catch (Exception e) {
            return c;
        }
    }

    static String[][] wordWithLength(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(lengthWithoutLength(words[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[] words = text.split(" ");
        String[][] data = wordWithLength(words);

        System.out.println("Word\tLength");
        for (String[] row : data)
            System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));

        sc.close();
    }
}
