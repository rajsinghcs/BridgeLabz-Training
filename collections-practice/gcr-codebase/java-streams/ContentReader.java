import java.util.*;
import java.io.*;
public class ContentReader {
    public static void main(String [] args){
        FileInputStream fileInput = null;
        FileOutputStream fileOutput = null;

        try{
            fileInput = new FileInputStream("input.txt");
            fileOutput = new FileOutputStream("output.txt");

            int data;

            while((data = fileInput.read()) != -1 ){
                fileOutput.write(data);
            }

            System.out.println("File copied successfully");

        }catch(FileNotFoundException e){
            System.out.println("file doesnot exist");
        }catch(IOException e){
            System.out.println("Error while reading/writing file");
        }finally{
            try{
                if(fileInput != null) fileInput.close();
                if(fileOutput != null) fileOutput.close();
            }catch(IOException e){
                System.out.println("Error closing file");
            }
        }
    }
}
