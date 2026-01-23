import java.util.*;

public class RotateList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        int k = 2;
        int n = list.size();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            result.add(list.get((i + k) % n));
        }

        System.out.println(result);
    }
}
