import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class  Delete {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/SCOTT";
        String user = "root";
        String password = "harini17";

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // 1️⃣ Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2️⃣ Establish connection
            conn = DriverManager.getConnection(url, user, password);

            // 3️⃣ Create SQL query with placeholders (?)
            String sql = "DELETE from dept WHERE dname = ?";

            // 4️⃣ Create PreparedStatement
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "CSBS");

            // 5️⃣ Execute the update
            int rows = pstmt.executeUpdate();  // No need to pass SQL again
            if (rows > 0) {
                System.out.println("A DEPARTMENT deleted successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
