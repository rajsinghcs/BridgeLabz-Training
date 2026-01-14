public class CircularTour {

    static int findStart(int[] petrol, int[] distance) {
        int totalPetrol = 0;
        int currentPetrol = 0;
        int start = 0;

        for (int i = 0; i < petrol.length; i++) {
            totalPetrol += petrol[i] - distance[i];
            currentPetrol += petrol[i] - distance[i];

            if (currentPetrol < 0) {
                start = i + 1;
                currentPetrol = 0;
            }
        }
        return totalPetrol >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {6, 3, 7};
        int[] distance = {4, 6, 3};

        int start = findStart(petrol, distance);

        if (start == -1)
            System.out.println("No possible circular tour");
        else
            System.out.println("Start at petrol pump index: " + start);
    }
}
