import java.util.*;

public class BinaryNumbers {
    public static void generateBinary(int n) {
        Queue<String> q = new LinkedList<>();
        q.add("1");

        for (int i = 0; i < n; i++) {
            String curr = q.remove();
            System.out.print(curr + " ");

            q.add(curr + "0");
            q.add(curr + "1");
        }
    }

    public static void main(String[] args) {
        generateBinary(5);
    }
}
