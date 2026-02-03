import java.util.*;
import java.util.*;

public class Program {

    public void registerCreator(CreatorStats record) {
        CreatorStats.EngagementBoard.add(record);
    }

    public Map<String, Integer> getTopPostCounts(List<CreatorStats> records, double likeThreshold) {
        Map<String, Integer> result = new LinkedHashMap<>();

        for (CreatorStats cs : records) {
            int count = 0;
            for (double likes : cs.getWeeklyLikes()) {
                if (likes >= likeThreshold) {
                    count++;
                }
            }
            if (count > 0) {
                result.put(cs.getCreatorName(), count);
            }
        }
        return result;
    }

    public double calculateAverageLikes() {
        double sum = 0;
        int count = 0;

        for (CreatorStats cs : CreatorStats.EngagementBoard) {
            for (double likes : cs.getWeeklyLikes()) {
                sum += likes;
                count++;
            }
        }

        return count == 0 ? 0 : sum / count;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Program program = new Program();

        while (true) {
            System.out.println("\n1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                CreatorStats cs = new CreatorStats();

                System.out.println("Enter Creator Name:");
                cs.setCreatorName(sc.nextLine());

                double[] likes = new double[4];
                System.out.println("Enter likes (Week 1 to 4):");
                for (int i = 0; i < 4; i++) {
                    likes[i] = sc.nextDouble();
                }
                cs.setWeeklyLikes(likes);

                program.registerCreator(cs);
                System.out.println("Creator registered successfully");

            } else if (choice == 2) {
                System.out.println("Enter like threshold:");
                double threshold = sc.nextDouble();

                Map<String, Integer> result =
                        program.getTopPostCounts(CreatorStats.EngagementBoard, threshold);

                if (result.isEmpty()) {
                    System.out.println("No top-performing posts this week");
                } else {
                    for (Map.Entry<String, Integer> entry : result.entrySet()) {
                        System.out.println(entry.getKey() + " - " + entry.getValue());
                    }
                }

            } else if (choice == 3) {
                double avg = program.calculateAverageLikes();
                System.out.println("Overall average weekly likes: " + (int) avg);

            } else if (choice == 4) {
                System.out.println("Logging off - Keep Creating with StreamBuzz!");
                break;
            }
        }
        sc.close();
    }
}
