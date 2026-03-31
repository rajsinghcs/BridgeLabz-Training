import com.healthclinic.model.Doctor;
import com.healthclinic.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctors WHERE is_active = TRUE";
        try (Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Doctor d = new Doctor();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setSpecialtyId(rs.getInt("specialty_id"));
                d.setContact(rs.getString("contact"));
                d.setEmail(rs.getString("email"));
                d.setConsultationFee(rs.getDouble("consultation_fee"));
                doctors.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }

    public Doctor getDoctorById(int id) {
        String sql = "SELECT * FROM doctors WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Doctor d = new Doctor();
                d.setId(rs.getInt("id"));
                d.setName(rs.getString("name"));
                d.setSpecialtyId(rs.getInt("specialty_id"));
                d.setContact(rs.getString("contact"));
                d.setEmail(rs.getString("email"));
                d.setConsultationFee(rs.getDouble("consultation_fee"));
                return d;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Not found
    }
}