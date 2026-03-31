import java.util.Random;

public class FootballTeamHeight {
    public static void main(String[] args) {

        // Array to store heights of 11 players
        int[] heights = new int[11];

        // Generate random heights between 150 and 250 cm
        generateHeights(heights);

        // Display all heights
        System.out.println("Player Heights:");
        for (int h : heights) {
            System.out.print(h + " ");
        }
        System.out.println();

        // Calling utility methods
        int sum = findSum(heights);
        double mean = findMean(heights);
        int shortest = findShortest(heights);
        int tallest = findTallest(heights);

        // Display results
        System.out.println("Sum of heights: " + sum);
        System.out.println("Mean height: " + mean);
        System.out.println("Shortest height: " + shortest);
        System.out.println("Tallest height: " + tallest);
    }

    // Method to generate random heights between 150 and 250
    static void generateHeights(int[] heights) {
        Random random = new Random();

        for (int i = 0; i < heights.length; i++) {
            // random.nextInt(101) gives 0–100, so add 150
            heights[i] = random.nextInt(101) + 150;
        }
    }

    // Method to find sum of array elements
    static int findSum(int[] arr) {
        int sum = 0;

        for (int val : arr) {
            sum += val;
        }
        return sum;
    }

    // Method to find mean height
    static double findMean(int[] arr) {
        // Mean = sum / number of elements
        return (double) findSum(arr) / arr.length;
    }

    // Method to find shortest height
    static int findShortest(int[] arr) {
        int min = Integer.MAX_VALUE;

        for (int val : arr) {
            if (val < min) {
                min = val;
            }
        }
        return min;
    }

    // Method to find tallest height
    static int findTallest(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int val : arr) {
            if (val > max) {
                max = val;
            }
        }
        return max;
    }
}
