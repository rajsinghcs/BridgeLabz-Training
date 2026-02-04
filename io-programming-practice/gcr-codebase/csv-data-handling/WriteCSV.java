import java.io.*;

public class WriteCSV {
    public static void main(String[] args) throws Exception {
        FileWriter fw = new FileWriter("employees.csv");

        fw.write("ID,Name,Department,Salary\n");
        fw.write("1,Raj,IT,50000\n");
        fw.write("2,Amit,HR,45000\n");
        fw.write("3,Neha,Finance,60000\n");
        fw.write("4,Pooja,IT,55000\n");
        fw.write("5,Karan,Sales,48000\n");

        fw.close();
        System.out.println("CSV file written successfully");
    }
}
