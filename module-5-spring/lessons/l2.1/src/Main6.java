import java.sql.*;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hotel";
        String username = "study";
        String password = "1234";
        try {
            Connection connection= DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            String query = "insert into employees (name, job, salary) values(?, ?, ?);";

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                Scanner scanner = new Scanner(System.in);

                while (true) {
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Job: ");
                    String job = scanner.nextLine();
                    System.out.print("Salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine();
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, job);
                    preparedStatement.setDouble(3, salary);
                    preparedStatement.addBatch();
                    System.out.println("Добавить следующее значение (Y / N): ");
                    String res = scanner.next();
                    if (res.equalsIgnoreCase("N")) {
                        break;
                    }
                    preparedStatement.executeBatch();
                    connection.commit();
                    System.out.println("Пакетная обработка прошла успешно");
                }
            } catch (BatchUpdateException e) {
                connection.rollback();
                System.out.println("Ошибка обработки пакета");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}