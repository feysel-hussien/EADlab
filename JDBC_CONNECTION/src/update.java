import java.sql.*;

public class update {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "7079";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            
            String updatedGrade = "90" ;
            int updateId = 1;

            String query = "UPDATE students SET grade = " + updatedGrade + " WHERE id = " + updateId;

            statement.executeUpdate(query);
            System.out.println("Updated Successfully!");
            
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}