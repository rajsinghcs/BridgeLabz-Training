import java.sql.*;
import java.util.HashMap;

class Employees {
    int id;
    String name;
    String address;

    Employees(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String toString() {
        return id + " " + name + " " + address;
    }
}

public class EmployeeDetailSystem {

    static String url = "jdbc:mysql://localhost:3306/employee_db";
    static String user = "root";
    static String password = "Akashraj786@";

    static HashMap<Integer, Employees> map = new HashMap<>();

    public static void addEmployee(int id, String name, String address) throws Exception {

        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = con.prepareStatement("INSERT INTO employees VALUES (?, ?, ?)");

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, address);

        ps.executeUpdate();
        con.close();

        System.out.println("Employee Added: " + id);
    }

    public static void deleteEmployee(int id) throws Exception {

        Connection con = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = con.prepareStatement("DELETE FROM employees WHERE employee_id=?");

        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();

        System.out.println("Employee Deleted: " + id);
    }

    public static void fetchEmployees() throws Exception {

        Connection con = DriverManager.getConnection(url, user, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM employees");

        map.clear();

        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String address = rs.getString(3);

            map.put(id, new Employees(id, name, address));
        }

        System.out.println("Data Loaded successfully");
    }
    
    public static void display() {
        for (Employees e : map.values()) {
            System.out.println(e);
        }
    }
    
    public static int getMapSize() {
    	return map.size();
    }

    public static void main(String[] args) throws Exception {

        addEmployee(1, "Raj Bahadur Singh", "Agra");
        addEmployee(2, "Rohit", "Palwal");
        addEmployee(3, "Nived", "Mathura");


        deleteEmployee(3);

        fetchEmployees();
        display();
    }
}