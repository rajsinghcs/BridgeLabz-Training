public class Main {
    public static void main(String[] args){
        FileDownloaderThread t1 = new FileDownloaderThread("file1.txt");
        FileDownloaderThread t2 = new FileDownloaderThread("Document.pdf");
        FileDownloaderThread t3 = new FileDownloaderThread("Image.jpg");

        t1.start();
        t2.start();
        t3.start();

        try{
            t1.join();
            t2.join();
            t3.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("All downloads complete!");
    }
}
