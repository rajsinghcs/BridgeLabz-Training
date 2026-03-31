import java.util.*;

public class FindNthElement {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        int n = 2;

        Iterator<String> fast = list.iterator();
        Iterator<String> slow = list.iterator();

        for (int i = 0; i < n; i++) {
            fast.next();
        }

        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        System.out.println(slow.next());
    }
}
