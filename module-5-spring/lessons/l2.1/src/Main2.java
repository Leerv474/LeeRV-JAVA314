import javax.swing.*;
import java.sql.*;

public class Main2 {
    private static final String url = "jdbc:mysql://localhost:3306/hotel";
    private static final String username = "study";
    private static final String password = "1234";

    public static void main(String[] args) {
//        String query = "SELECT * FROM employees WHERE name = ?";
        String query = "insert into employees values (?, ?, ?, ?);";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 3);
            preparedStatement.setString(2, "Victor");
            preparedStatement.setString(3, "HR");
            ResultSet resultSet = preparedStatement.executeQuery();

//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String job = resultSet.getString("job");
//                double salary = resultSet.getDouble("salary");
//                System.out.println("ID: " + id);
//                System.out.println("NAME: " + name);
//                System.out.println("JOB: " + job);
//                System.out.println("SALARY: " + salary);
//            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}