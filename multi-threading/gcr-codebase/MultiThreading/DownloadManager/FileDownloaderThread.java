import java.util.Random;

public class FileDownloaderThread extends Thread {

    private String fileName;
    private Random random = new Random();

    public FileDownloaderThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        for (int progress = 0; progress <= 100; progress += 10) {
            System.out.println("[" + Thread.currentThread().getName() + 
                "] Downloading " + fileName + ": " + progress + "%");

            try {
                Thread.sleep(500 + random.nextInt(500)); // random delay
            } catch (InterruptedException e) {
                System.out.println("Download interrupted: " + fileName);
            }
        }
    }
}
