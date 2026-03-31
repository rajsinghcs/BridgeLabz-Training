public class PrintJob implements Runnable {

    private String jobName;
    private int pages;
    private int priority;

    public PrintJob(String jobName, int pages, int priority) {
        this.jobName = jobName;
        this.pages = pages;
        this.priority = priority;
    }

    private String getPriorityLabel() {
        if (priority >= 7) {
            return "High Priority";
        } else if (priority >= 5) {
            return "Medium Priority";
        } else {
            return "Low Priority";
        }
    }

    @Override
    public void run() {
        for (int i = 1; i <= pages; i++) {
            System.out.println("[" + getPriorityLabel() + "] Printing "
                    + jobName + " - Page " + i + " of " + pages);
            try {
                Thread.sleep(100); // 100ms per page
            } catch (InterruptedException e) {
                System.out.println(jobName + " interrupted");
            }
        }

        System.out.println(jobName + " completed by " +
                Thread.currentThread().getName());
    }
}
