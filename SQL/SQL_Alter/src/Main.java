import java.sql.*;
import java.util.ArrayList;
/**

 The Main class contains a method to modify a database table in MySQL.
 The modifications include adding a new column named "country" to the "student" table,
 and updating the "country" value for specific rows in the table.
 @author [Trupia Alessandro]
 @version 1.0
 */
public class Main {
/**
 * This method connects to a MySQL database and modifies the "student" table by adding a "country" column
 * and updating the "country" value for specific rows in the table.
 */
    public static void main(String[] args) {
        Connection conn = null;
        try {

            String url       = "jdbc:mysql://localhost:3306/newdb";
            String user      = "developer";
            String password  = "passwordhere";
            // establish connection
            conn = DriverManager.getConnection(url, user, password);

            // create a Statement object to execute SQL queries
            Statement s = conn.createStatement();

            // SQL query to add a new column to the "student" table
            String query = ("ALTER TABLE student ADD COLUMN country VARCHAR(30)");

            // execute the query to add the new column
            s.executeUpdate(query);

            // SQL queries to update the "country" value for specific rows in the "student" table
            s.executeUpdate("UPDATE student SET country = 'Italy' where student_id = 1;");
            s.executeUpdate("UPDATE student SET country = 'Italy' where student_id = 2;");
            s.executeUpdate("UPDATE student SET country = 'Germany' where student_id = 3;");
            s.executeUpdate("UPDATE student SET country = 'Germany' where student_id = 10;");

        } catch(SQLException e) {
            // print error message if SQL exception is thrown
            System.out.println("Error");
            System.out.println(e.getMessage());
        } finally {
            // close the database connection in the finally block
            try{
                if(conn != null)
                    conn.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
