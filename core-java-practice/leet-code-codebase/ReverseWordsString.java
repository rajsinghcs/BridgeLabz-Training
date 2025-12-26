import java.util.*;

class ReverseWordsString {

    // Method to reverse words in a string
    public String reverseWords(String s) {
        s = " " + s.trim();

        int n = s.length();   // Marks the end index of a word
        String res = "";      // Stores the final reversed string

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (i < n - 1) {
                    res += s.substring(i + 1, n) + " ";
                }
                n = i;
            }
        }

        // Remove extra space at the end
        return res.trim();
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        // Read full line input
        String str = sc.nextLine();
        ReverseWordsString obj = new ReverseWordsString();
        String result = obj.reverseWords(str);
        System.out.println(result);
        sc.close();
    }
}
