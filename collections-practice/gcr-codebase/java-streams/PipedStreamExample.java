import java.io.*;

public class PipedStreamExample {

    public static void main(String[] args) {
        try {
            // Create piped streams
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            // Writer thread
            Thread writer = new Thread(() -> {
                try {
                    String message = "Hello from Writer Thread!";
                    pos.write(message.getBytes());
                    pos.close(); 
                } catch (IOException e) {
                    System.out.println("Writer IO Error");
                }
            });

            // Reader thread
            Thread reader = new Thread(() -> {
                try {
                    int data;
                    while ((data = pis.read()) != -1) {
                        System.out.print((char) data);
                    }
                    pis.close();
                } catch (IOException e) {
                    System.out.println("Reader IO Error");
                }
            });

            // Start both threads
            writer.start();
            reader.start();

            // Wait for threads to finish
            writer.join();
            reader.join();

            System.out.println("\nCommunication completed.");

        } catch (IOException | InterruptedException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
