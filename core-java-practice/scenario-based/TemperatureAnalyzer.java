public class TemperatureAnalyzer {

    public static void analyzeTemperature(float[][] temp) {

        float maxTemp = Float.MIN_VALUE;
        float minTemp = Float.MAX_VALUE;
        int hottestDay = 0;
        int coldestDay = 0;

        // Loop through each day
        for (int day = 0; day < 7; day++) {
            float sum = 0;

            for (int hour = 0; hour < 24; hour++) {
                float currentTemp = temp[day][hour];
                sum += currentTemp;

                if (currentTemp > maxTemp) {
                    maxTemp = currentTemp;
                    hottestDay = day;
                }

                if (currentTemp < minTemp) {
                    minTemp = currentTemp;
                    coldestDay = day;
                }
            }

            float average = sum / 24;
            System.out.println("Average temperature of Day " + (day + 1) + ": " + average);
        }

        System.out.println("\nHottest Day: Day " + (hottestDay + 1));
        System.out.println("Coldest Day: Day " + (coldestDay + 1));
    }

    public static void main(String[] args) {
        float[][] temperatures = new float[7][24]; // filled with data
        analyzeTemperature(temperatures);
    }
}
