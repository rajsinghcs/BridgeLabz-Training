import java.util.*;

public class ReverseQueue {
    public static void reverse(Queue<Integer> q) {
        if (q.isEmpty()) return;

        int front = q.remove();
        reverse(q);
        q.add(front);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);

        reverse(q);
        System.out.println(q); 
    }
}
