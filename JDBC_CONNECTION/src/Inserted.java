

import java.sql.*;

public class Inserted {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/studentdb";
            String username ="root";
            String password = "7079";

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String[] insertItems = {
                "INSERT INTO students (id, firstname, lastname, grade) VALUES (1, 'Aster', 'Nega', 98)",
                "INSERT INTO students (id, firstname, lastname, grade) VALUES (2, 'John', 'Smith', 100)",
                "INSERT INTO students (id, firstname, lastname, grade) VALUES (3, 'Maria', 'Garcia', 95)",
                "INSERT INTO students (id, firstname, lastname, grade) VALUES (4, 'Robert', 'Johnson', 59)",
                "INSERT INTO students (id, firstname, lastname, grade) VALUES (5, 'Emily', 'Brown', 49)",
                "INSERT INTO students (id, firstname, lastname, grade) VALUES (6, 'Daniel', 'Lee', 82)",
                "INSERT INTO students (id, firstname, lastname, grade) VALUES (7, 'Sophia', 'Martinez', 42)",
                "INSERT INTO students (id, firstname, lastname, grade) VALUES (8, 'Michael', 'Taylor', 97)",
                "INSERT INTO students (id, firstname, lastname, grade) VALUES (9, 'Olivia', 'Anderson', 87)",
                "INSERT INTO students (id, firstname, lastname, grade) VALUES (10, 'William', 'Clark', 78)"
            };

            for (String student : insertItems) {
                String insertStatement = student;
                statement.executeUpdate(insertStatement);

            }
            System.out.println("Data inserted successfully!");

            statement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }
    }
    
}