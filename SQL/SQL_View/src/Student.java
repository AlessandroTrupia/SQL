/**
 * A class representing a student with a name and surname.
 */
public class Student {

    // Fields
    private final String url;      // The URL of the MySQL database
    private final String user;     // The username for the MySQL database
    private final String password; // The password for the MySQL database
    private String name;           // The student's first name
    private String surname;        // The student's last name

    /**
     * Constructs a new student with the given name and surname.
     *
     * @param name    the student's first name
     * @param surname the student's last name
     */
    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.url = "jdbc:mysql://localhost:3306/newdb";
        this.user = "developer";
        this.password = "passwordhere";
    }

    /**
     * Returns the student's first name.
     *
     * @return the student's first name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the student's last name.
     *
     * @return the student's last name
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Prints the student's name and surname to the console.
     */
    public void printStudentNameSurname() {
        System.out.println("Name: " + name + ", surname: " + surname);
    }
}