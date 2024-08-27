import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jbdc:mysql://localhost:3306/users1";
        String username = "root";
        String password = "1234";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "Select * from employees";
//            statement.executeUpdate("create table employees (id INT primary key auto_increment, name varchar(255), job varchar(255), salary double)");
//            statement.executeUpdate("insert into employees values(1, 'Roman', 'Java Developer', 75000.0)");
//            statement.executeUpdate("insert into employees (name, job, salary) values('Sergey', 'Java Developer', 75000.0)");

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job = rs.getString("job");
                double salary = rs.getDouble("salary");
                System.out.println();
                System.out.println("==================================");
                System.out.printf("ID: %n\nName: %s\nJob: %s\nSalary: %n\n", id, name, job, salary);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
