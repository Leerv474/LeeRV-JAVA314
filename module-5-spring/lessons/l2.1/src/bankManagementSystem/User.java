package bankManagementSystem;

import java.sql.*;
import java.util.Scanner;

public class User {
    private Connection connection;
    private Scanner scanner;

    public User(Connection connection, Scanner scanner) {
        this.connection = connection;
        this.scanner = scanner;
    }

    public void register() {
        scanner.nextLine();
        System.out.print("Имя: ");
        String fullName = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Пароль: ");
        String password = scanner.nextLine();

        if (userExists(email)) {
            System.out.println("Пользователь с таким адресом электронной почты уже существует");
            return;
        }

        String registerQuery = "insert into user values(?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(registerQuery);
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            int row = preparedStatement.executeUpdate();
            if (row > 0) {
                System.out.println("Регистрация прошла успешно");
            } else {
                System.out.println("Регистрация не удалась");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private boolean userExists(String email) {
        String query = "select * from user where email = ?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
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

    public String login() {
        scanner.nextLine();
        System.out.print("\nEmail: ");
        String email = scanner.nextLine();
        System.out.print("Пароль: ");
        String password = scanner.nextLine();

        String loginQuery = "select * from user where email = ? and password = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.executeQuery();
            ResultSet resultSet =preparedStatement.executeQuery();
            if (resultSet.next()) {
                return email;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}