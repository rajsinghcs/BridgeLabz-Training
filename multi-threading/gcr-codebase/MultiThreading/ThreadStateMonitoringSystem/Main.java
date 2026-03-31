public class Main {
    public static void main(String[] args){
        Thread task1 = new Thread(new TaskRunner("Task-1"), "Task-1");
        Thread task2 = new Thread(new TaskRunner("Task-2"), "Task-2");

        Thread[] tasks = {task1, task2};

        // NEW state
        System.out.println("[Monitor] Task-1 is in NEW state at " + java.time.LocalTime.now());
        System.out.println("[Monitor] Task-2 is in NEW state at " + java.time.LocalTime.now());

        StateMonitor monitor = new StateMonitor(tasks);
        monitor.start();

        task1.start();
        task2.start();
    }
}
