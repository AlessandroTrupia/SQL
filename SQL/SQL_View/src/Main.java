import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {
        /**
         * The main method that creates the views and retrieves students from each view
         */
        Connection conn;
        String url       = "jdbc:mysql://localhost:3306/newdb";
        String user      = "developer";
        String password  = "passwordhere";
        conn = DriverManager.getConnection(url, user, password);
        Statement s = conn.createStatement();
        // create a view of Italian students
        String str = "CREATE VIEW italian_students AS\n" +
                "SELECT last_name, first_name\n" +
                "FROM student\n" +
                "WHERE Country = \"Italy\";";
        // create a view of German students
        String str1 = "CREATE VIEW german_students AS\n" +
                "SELECT last_name, first_name\n" +
                "FROM student\n" +
                "WHERE Country = \"Germany\";";
        s.executeUpdate(str);
        s.executeUpdate(str1);

        // retrieve and print Italian students
        ArrayList <Student> italianStudent = new ArrayList<>();
        ResultSet rs1 = s.executeQuery("SELECT first_name, last_name FROM italian_students");
        while (rs1.next()){
            italianStudent.add(new Student(rs1.getString("first_name"), rs1.getString("last_name")));
        }
        for (Student name : italianStudent) {
            name.printStudentNameSurname();
        }
        // retrieve and print German students
        ArrayList <Student> germanStudent = new ArrayList<>();
        ResultSet rs2 = s.executeQuery("SELECT first_name, last_name FROM german_students");
        while (rs2.next()){
            germanStudent.add(new Student(rs2.getString("first_name"), rs2.getString("last_name")));
        }
        for (Student name : germanStudent) {
            name.printStudentNameSurname();
        }
        conn.close();
    }
}



