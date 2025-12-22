public class TrimWithoutTrim {

    static int[] trimIndex(String text) {
        int start = 0, end = text.length() - 1;

        while (text.charAt(start) == ' ') start++;
        while (text.charAt(end) == ' ') end--;

        return new int[]{start, end};
    }

    static String substring(String s, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++)
            result += s.charAt(i);
        return result;
    }

    public static void main(String[] args) {
        String text = "   Hello Java   ";
        int[] idx = trimIndex(text);

        String custom = substring(text, idx[0], idx[1]);
        System.out.println(custom.equals(text.trim()));
    }
}

