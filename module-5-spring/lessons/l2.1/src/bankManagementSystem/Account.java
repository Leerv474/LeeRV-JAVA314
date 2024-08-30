package bankManagementSystem;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class Account {
    private Connection connection;
    private Scanner scanner;

    public Account(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public boolean accountExists(String email) {
        String query = "select account_number from account where email = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public long openAccount(String email) {
        if (accountExists(email)) {
            throw new RuntimeException("Аккаунт уже существует");
        }

        String openAccountQuery = "insert into account values (?, ?, ?, ?, ?)";
        scanner.nextLine();
        System.out.print("Имя: ");
        String fullName = scanner.nextLine();
        System.out.print("Введите начальную сумму: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Введите PIN-код: ");
        String securityPin = scanner.nextLine();

        try {
            long accountNumber = generateAccountNumber();
            PreparedStatement preparedStatement = connection.prepareStatement(openAccountQuery);
            preparedStatement.setLong(1, accountNumber);
            preparedStatement.setString(2, fullName);
            preparedStatement.setString(3, email);
            preparedStatement.setDouble(4, balance);
            preparedStatement.setString(5,securityPin);
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                return accountNumber;
            } else {
                throw new RuntimeException("Создание учетной записи не удалось");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private long generateAccountNumber() {
        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select account_number from account order by account_number desc limit 1");
            if (resultSet.next()) {
                long lastAccountNumber = resultSet.getLong("account_number");
                return lastAccountNumber+1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1000000;
    }

    public long getAccountNumber(String email) {
        String query = "select account_number from account where email = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getLong("account_number");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Такой номер счета не существует");
    }
}