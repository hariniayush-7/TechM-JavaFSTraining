import java.sql.*;

public class Insert {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/SCOTT";
        String user = "root";
        String password = "harini17";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
          
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO dept (deptno, dname, loc) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 7);  // First parameter (Department Number)
            pstmt.setString(2, "CSBS"); // Second parameter (Department Name)
            pstmt.setString(3, "COMM"); // Third parameter (Location)
            int rows = pstmt.executeUpdate(); // Corrected
            System.out.println("Rows inserted: " + rows);

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
