import java.sql.*;
import java.util.ArrayList;

public class StudentDAO{

     public static void addStudent(Student s) {
        String query = "INSERT INTO students (name, age, marks) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, s.name);
            ps.setInt(2, s.getAge());
            ps.setInt(3, s.getMarks());

            ps.executeUpdate();
            System.out.println("Student inserted successfully!");

        } catch (Exception e) {
            System.out.println("Error in addStudent: " + e.getMessage());
        }
    }

    // READ — GET ALL STUDENTS
    public static ArrayList<Student> getAllStudents() {
        ArrayList<Student> list = new ArrayList<>();

        String query = "SELECT * FROM students";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Student s = new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getInt("marks")
                );
                list.add(s);
            }

        } catch (Exception e) {
            System.out.println("Error in getAllStudents: " + e.getMessage());
        }

        return list;
    }

    // UPDATE — UPDATE MARKS OF A STUDENT
    public static void updateStudentMarks(int id, int newMarks) {
        String query = "UPDATE students SET marks = ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, newMarks);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Marks updated successfully!");
            else
                System.out.println("Student ID not found!");

        } catch (Exception e) {
            System.out.println("Error in updateStudentMarks: " + e.getMessage());
        }
    }

     // DELETE — DELETE STUDENT
    public static void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student deleted successfully!");
            else
                System.out.println("Student ID not found!");

        } catch (Exception e) {
            System.out.println("Error in deleteStudent: " + e.getMessage());
        }
    }

     // SEARCH 
    public static Student getStudentById(int id) {

    String query = "SELECT * FROM students WHERE id = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(query)) {

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            // Student found
            return new Student(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("age"),
                rs.getInt("marks")
            );
        }

    } catch (Exception e) {
        System.out.println("Error in getStudentById: " + e.getMessage());
    }

    return null; // Student not found
}


}