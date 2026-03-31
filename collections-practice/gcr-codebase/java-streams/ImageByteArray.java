import java.io.*;

public class ImageByteArray {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("input.jpg");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int data;
            while ((data = fis.read()) != -1) {
                baos.write(data);
            }

            byte[] imageBytes = baos.toByteArray();

            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream("output.jpg");

            while ((data = bais.read()) != -1) {
                fos.write(data);
            }

            fis.close();
            baos.close();
            bais.close();
            fos.close();

            System.out.println("Image copied successfully");

        } catch (IOException e) {
            System.out.println("IO Error occurred");
        }
    }
}
