import java.util.Scanner;
public class StudentRecordManagement {

    static Node head;
    static Node tail;
    static class Node{
        String name;
        int age;
        int rollNo;
        char grade;
        Node next;

        Node(String name, int age, int rollNo, char grade){
            this.name = name;
            this.age = age;
            this.rollNo = rollNo;
            this.grade = grade;
            this.next = null;
        }
    }

        public static void addStudent(Node newNode){
            if(head == null){
                head = newNode;
                tail = newNode;
            }else{
                tail.next = newNode;
                tail = newNode;
            } 
        }

        public static void displayStudents(){
            Node temp = head;
            if(temp == null){
                System.out.println("\nNo student records available.");
                return;
            }
            while(temp != null){
                System.out.println("Name: " + temp.name + ", Age: " + temp.age + ", Roll No: " + temp.rollNo + ", Grade: " + temp.grade);
                temp = temp.next;
            }
            
        }

        public static void searchStudent(int rollNo){
            Node temp = head;
            while( temp != null){
                if(temp.rollNo == rollNo){
                    System.out.println("\nStudent Found: Name: " + temp.name + ", Age: " + temp.age + ", Roll No: " + temp.rollNo + ", Grade: " + temp.grade);
                    return;
                }
                temp = temp.next;
            }
            System.out.println("Student with Roll No " + rollNo + " not found.");
            
        }

        public static void deleteStudent(int rollNo){

            if(head == null){
                System.out.println("List is empty. Cannot delete.");
                return;
            } 
            if(head.rollNo == rollNo){
                if(head == tail){
                    head = null;
                    tail = null;
                    System.out.println("Student with Roll No " + rollNo + " deleted.");
                    return;
                }
                head = head.next;
                System.out.println("Student with Roll No " + rollNo + " deleted.");
                return;
            }

            Node temp = head.next;
            Node prev = head;
            while(temp != null){
                if(temp.rollNo == rollNo){
                    prev.next = temp.next;
                    System.out.println("Student with Roll No " + rollNo + " deleted.");
                    return;
                }
                prev = temp;
                temp = temp.next;

            }
            
        }

        public static void updateStudentGrade(int rollNo, char newGrade){
         Node temp = head;
            while(temp != null){
                if(temp.rollNo == rollNo){
                    System.out.println("\nStudent with Roll No " + rollNo + " has been updated to Grade " + newGrade);
                    return;
                }
            }
            System.out.println("\nStudent with Roll No " + rollNo + " not found.");
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node node1 = new Node("Rohit Rawat", 21, 1492, 'B');
        Node node2 = new Node("Raj Bahadur Singh", 21, 1402, 'A');
        Node node3 = new Node("Nived Agrawal", 21, 1191,'B');
        Node node4 = new Node("Priyanshu Sharma", 20, 1339 ,'A');
        Node node5 = new Node("Sachin", 21, 1493, 'C');
        
        addStudent(node1);
        addStudent(node2);
        addStudent(node3);
        addStudent(node4);
        addStudent(node5);
        displayStudents();

        searchStudent(1402);
        deleteStudent(1493);
        updateStudentGrade(1492, 'A');
    }
}
