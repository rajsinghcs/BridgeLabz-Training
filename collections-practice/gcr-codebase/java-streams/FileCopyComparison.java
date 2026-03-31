import java.io.*;

public class FileCopyComparison {

    public static void main(String[] args) throws IOException {

        String sourceFile = "input.txt";

        copyUsingNormalStream(sourceFile, "output_normal.txt");
        copyUsingBufferedStream(sourceFile, "output_buffered.txt");
    }

    static void copyUsingNormalStream(String source, String destination) throws IOException {
        FileInputStream fis = new FileInputStream(source);
        FileOutputStream fos = new FileOutputStream(destination);

        byte[] buffer = new byte[4096];
        int bytesRead;

        long startTime = System.nanoTime();

        while ((bytesRead = fis.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }

        long endTime = System.nanoTime();

        fis.close();
        fos.close();

        System.out.println("Normal Stream Time (ns): " + (endTime - startTime));
    }

    static void copyUsingBufferedStream(String source, String destination) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination));

        byte[] buffer = new byte[4096];
        int bytesRead;

        long startTime = System.nanoTime();

        while ((bytesRead = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }

        long endTime = System.nanoTime();

        bis.close();
        bos.close();

        System.out.println("Buffered Stream Time (ns): " + (endTime - startTime));
    }
}
