import java.util.*;
import java.io.*;
public class ReadFile {
    public static void main(String[]args){
        try{
            FileInputStream fis = new FileInputStream("data.txt");
            int data;
            while(((data = fis.read()) != -1)){
                System.out.print((char)data);
            }
        }catch(IOException e){
            System.out.println("File Not Found");
        }
    }
}
