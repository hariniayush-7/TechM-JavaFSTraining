import java.sql.*;
import java.util.Scanner;

public class Menu {
    private static final String URL = "jdbc:mysql://localhost:3306/SCOTT";
    private static final String USER = "root";
    private static final String PASSWORD = "harini17";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Insert a new Row");
            System.out.println("2. Update a Row");
            System.out.println("3. Delete a Row");
            System.out.println("4. Select the row");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insertRow(scanner);
                    break;
                case 2:
                    updateRow(scanner);
                    break;
                case 3:
                    deleteRow(scanner);
                    break;
                case 4:
                    selectRow();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void insertRow(Scanner scanner) {
        System.out.print("Enter data to insert: ");
        String data = scanner.next();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement("INSERT INTO dept (deptno, dname, loc) VALUES (?, ?, ?)")) {
            pstmt.setInt(1, 3);  // First parameter (Department Number)
            pstmt.setString(2, "CSE"); // Second parameter (Department Name)
            pstmt.setString(3, "ML"); // Third parameter (Location)
            pstmt.executeUpdate();
            System.out.println("Row inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateRow(Scanner scanner) {
        System.out.print("Enter id of the row to update: ");
        int id = scanner.nextInt();
        System.out.print("Enter new data: ");
        String newData = scanner.next();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement("UPDATE dept SET dname = ? WHERE deptno = ?")) {
            pstmt.setString(1, "IT");
            pstmt.setFloat(2, 9);
            pstmt.executeUpdate();
            System.out.println("Row updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteRow(Scanner scanner) {
        System.out.print("Enter id of the row to delete: ");
        int id = scanner.nextInt();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = connection.prepareStatement("DELETE from dept WHERE dname = ?")) {
            pstmt.setString(1, "CSBS");
            pstmt.executeUpdate();
            System.out.println("Row deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void selectRow() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table")) {
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Data: " + resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}