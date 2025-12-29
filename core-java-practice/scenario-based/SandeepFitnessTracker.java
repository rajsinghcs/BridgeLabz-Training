public class SandeepFitnessTracker {

    public static void main(String[] args) {

        // Push-ups done each day (0 means rest day)
        int[] pushUps = {30, 40, 0, 50, 60, 0, 45};

        int total = 0;
        int activeDays = 0;

        // Calculate total and average using for-each loop
        for (int count : pushUps) {
            if (count == 0) {
                continue; // skip rest days
            }
            total += count;
            activeDays++;
        }

        double average = (activeDays > 0) ? (double) total / activeDays : 0;

        System.out.println("Total Push-ups: " + total);
        System.out.println("Average Push-ups per active day: " + average);
    }
}
