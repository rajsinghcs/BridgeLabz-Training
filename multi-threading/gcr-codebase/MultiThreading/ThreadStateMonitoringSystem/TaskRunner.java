public class TaskRunner implements Runnable {

    private String taskName;

    public TaskRunner(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 1_000_000; i++) {
                int x = i * i;
            }

            Thread.sleep(2000);

        } catch (InterruptedException e) {
            System.out.println(taskName + " interrupted");
        }
    }
}
