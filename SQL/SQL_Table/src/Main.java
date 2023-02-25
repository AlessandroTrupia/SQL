import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * The main method connects to the database, creates a new table named "student"
 * and inserts four students' records into the table.
 */
public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {

            String url       = "jdbc:mysql://localhost:3306/newdb";
            String user      = "developer";
            String password  = "passwordhere";

            conn = DriverManager.getConnection(url, user, password);

            Statement query = conn.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS student " +
                    "(student_id INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    " last_name VARCHAR(30), " +
                    " first_name VARCHAR(30))";

            query.executeUpdate(sql);

            query.execute("INSERT INTO newdb.student (last_name, first_name)VALUES('Red', 'Dario');");
            query.execute("INSERT INTO newdb.student (last_name, first_name)VALUES('Blue', 'Pino');");
            query.execute("INSERT INTO newdb.student (last_name, first_name)VALUES('Green', 'Gianni');");
            query.execute("INSERT INTO newdb.student (last_name, first_name)VALUES('Purple', 'Aldo');");

        } catch(SQLException e) {
            System.out.println(e.getMessage());
        } finally {

            try{
                if(conn != null)
                conn.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
