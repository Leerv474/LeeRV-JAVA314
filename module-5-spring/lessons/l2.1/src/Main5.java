import java.sql.*;

public class Main5 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hotel";
        String username = "study";
        String password = "1234";

        try {
            Connection connection= DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);

            try {
                Statement statement = connection.createStatement();
                statement.addBatch("insert into employees(name, job, salary) values('Igor', 'HR Manager', 65000);");
                statement.addBatch("insert into employees(name, job, salary) values('Oleg', 'CPP Developer', 65000);");
                statement.addBatch("insert into employees(name, job, salary) values('Peter', 'JS Developer', 65000);");
                statement.executeBatch();
                connection.commit();
                System.out.println("Пакетная обработка прошла успешно");
            } catch (BatchUpdateException e) {
                connection.rollback();
                System.out.println("Ошибка пакетной обработки");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}