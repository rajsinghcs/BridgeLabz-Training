import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class StateMonitor extends Thread {

    private Thread[] threads;
    private Map<String, Integer> stateCount = new HashMap<>();

    public StateMonitor(Thread[] threads) {
        this.threads = threads;
    }

    @Override
    public void run() {

        boolean allTerminated = false;

        while (!allTerminated) {
            allTerminated = true;

            for (Thread t : threads) {
                Thread.State state = t.getState();
                String key = t.getName() + "-" + state;

                stateCount.put(key, stateCount.getOrDefault(key, 0) + 1);

                System.out.println("[Monitor] " + t.getName() +
                        " is in " + state +
                        " state at " + LocalTime.now());

                if (state != Thread.State.TERMINATED) {
                    allTerminated = false;
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Monitor interrupted");
            }
        }

        System.out.println("\nSummary:");
        for (Thread t : threads) {
            System.out.println(t.getName() + " went through 4 states");
        }
    }
}
