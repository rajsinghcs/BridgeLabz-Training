import java.util.*;
public class ReverseString {
    public static void main(String[] args) {
        String input = "hello";

        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb.reverse();

        String result = sb.toString();
        System.out.println(result);
    }
}
