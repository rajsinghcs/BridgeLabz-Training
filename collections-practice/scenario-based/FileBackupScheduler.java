import java.util.*;

class InvalidBackupPathException extends Exception {
    public InvalidBackupPathException(String message) {
        super(message);
    }
}

class BackupTask implements Comparable<BackupTask> {
    String path;
    int priority;

    public BackupTask(String path, int priority) {
        this.path = path;
        this.priority = priority;
    }

    @Override
    public int compareTo(BackupTask other) {
        return other.priority - this.priority;
    }

    @Override
    public String toString() {
        return "Backing up: " + path + " | Priority: " + priority;
    }
}

public class FileBackupScheduler {

    PriorityQueue<BackupTask> queue;

    public FileBackupScheduler() {
        queue = new PriorityQueue<>();
    }

    public void addBackupTask(String path, int priority) throws InvalidBackupPathException {
        if (path == null || path.trim().isEmpty()) {
            throw new InvalidBackupPathException("Invalid backup path provided");
        }

        BackupTask task = new BackupTask(path, priority);
        queue.add(task);
    }

    public void executeBackups() {
        System.out.println("Executing Backup Tasks\n");

        while (!queue.isEmpty()) {
            BackupTask task = queue.poll();
            System.out.println(task);
        }
    }

    
    public static void main(String[] args) {
        FileBackupScheduler scheduler = new FileBackupScheduler();

        try {
            scheduler.addBackupTask("/documents", 2);
            scheduler.addBackupTask("/system", 10);
            scheduler.addBackupTask("/photos", 1);
            // scheduler.addBackupTask("", 5);
        } catch (InvalidBackupPathException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scheduler.executeBackups();
    }
}
