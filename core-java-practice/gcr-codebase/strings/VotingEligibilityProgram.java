import java.util.Scanner;

public class VotingEligibilityProgram {

    static int[] generateAges(int n) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++)
            ages[i] = (int) (Math.random() * 90);
        return ages;
    }

    static String[][] canVote(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            result[i][1] = ages[i] >= 18 ? "True" : "False";
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ages = generateAges(10);
        String[][] data = canVote(ages);

        System.out.println("Age\tCan Vote");
        for (String[] row : data)
            System.out.println(row[0] + "\t" + row[1]);
    }
}
