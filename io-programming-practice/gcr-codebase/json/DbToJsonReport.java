package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.sql.*;

public class DbToJsonReport {

    public static void main(String[] args) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        ArrayNode report = mapper.createArrayNode();

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "password");

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM students");

        while (rs.next()) {
            ObjectNode obj = mapper.createObjectNode();
            obj.put("id", rs.getInt("id"));
            obj.put("name", rs.getString("name"));
            obj.put("email", rs.getString("email"));
            obj.put("age", rs.getInt("age"));
            report.add(obj);
        }

        con.close();

        System.out.println(
            mapper.writerWithDefaultPrettyPrinter().writeValueAsString(report)
        );
    }
}

