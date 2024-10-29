import java.sql.*;

public class delete {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "7079";

        try {

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            int deleteId = 6;

            String query = "DELETE FROM STUDENTS WHERE id = " + deleteId;

            statement.executeUpdate(query);
            System.out.println("Deleted Successfully!");

            statement.close();
            connection.close();


        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
    }
}