import java.io.*;

public class StudentDataStream {
    public static void main(String[] args) {

        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("student.dat"));

            dos.writeInt(101);
            dos.writeUTF("Rahul");
            dos.writeDouble(8.6);

            dos.close();

            DataInputStream dis = new DataInputStream(new FileInputStream("student.dat"));

            int roll = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            dis.close();

            System.out.println("Roll No: " + roll);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);

        } catch (IOException e) {
            System.out.println("IO Error occurred");
        }
    }
}
