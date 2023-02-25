import java.sql.*;
import java.util.ArrayList;
/**
 * The main method connects to the database, creates a new table named "student",
 * inserts four students' records into the table, retrieves the students' first and last names,
 * and prints the first names to the console and the last names to an ArrayList.
 */
 public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            String url       = "jdbc:mysql://localhost:3306/newdb";
            String user      = "developer";
            String password  = "passwordhere";
            conn = DriverManager.getConnection(url, user, password);

            Statement s = conn.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS student " +
                    "(student_id INTEGER(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    " last_name VARCHAR(30), " +
                    " first_name VARCHAR(30))";

            ArrayList<String> surnames = new ArrayList<>();

            s.executeUpdate(sql);

            s.execute("INSERT INTO newdb.student (last_name, first_name)VALUES('Red', 'Dario');");
            s.execute("INSERT INTO newdb.student (last_name, first_name)VALUES('Blue', 'Pino');");
            s.execute("INSERT INTO newdb.student (last_name, first_name)VALUES('Green', 'Gianni');");
            s.execute("INSERT INTO newdb.student (last_name, first_name)VALUES('Purple', 'Aldo');");

            ResultSet rs = s.executeQuery("SELECT first_name, last_name FROM newdb.student");

            while (rs.next()) {
                surnames.add(rs.getString("last_name"));
                System.out.println(rs.getString("first_name"));
            }

            System.out.println(surnames);

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
