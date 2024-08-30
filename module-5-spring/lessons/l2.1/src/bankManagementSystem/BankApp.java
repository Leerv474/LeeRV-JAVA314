package bankManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class BankApp {
    private static final String url = "jdbc:mysql://localhost:3306/bank_system";
    private static final String username = "study";
    private static final String password = "1234";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Scanner scanner = new Scanner(System.in);
            User user = new User(connection, scanner);
            Account account = new Account(connection, scanner);

            String email;
            long accountNumber;
            while (true) {
                System.out.println("***ДОБРО ПОЖАЛОВАТЬ В БАНКОВСКУЮ СИСТЕМУ***\n");
                System.out.println("1. Регистрация");
                System.out.println("2. Авторизация");
                System.out.println("3. Выход");
                System.out.print("Ваш выбор: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        user.register();
                        break;
                    case 2:
                        email = user.login();
                        if (email != null) {
                            System.out.println("Пользователь вошел в систему");
                            if (!account.accountExists(email)) {
                                System.out.println("1. Открытие нового банковского счета");
                                System.out.println("2. Выход");
                                System.out.print("Ваш выбор: ");
                                if (scanner.nextInt() == 1) {
                                    accountNumber = account.openAccount(email);
                                } else {
                                    break;
                                }
                            }
                            accountNumber = account.getAccountNumber(email);
                            int choice1 = 0;
                            while (choice1 != 5) {
                                System.out.println("\n1. Снятие личных средств");
                                System.out.println("2. Займ кредитных средств");
                                System.out.println("3. Перевод денег");
                                System.out.println("4. Проверка баланса");
                                System.out.println("5. Выход");
                                System.out.println("Ваш выбор: ");

                                int  choice2 = scanner.nextInt();
                                switch (choice2) {
                                    case 5:
                                        break;
                                    default:
                                        System.out.println("Такой опции нет");
                                        break;
                                }
                            }

                        } else {
                            System.out.println("Неправильный адрес почты или пароль");
                        }
                        break;
                    case 3:
                        System.out.println("СПАСИБО ЗА ИСПОЛЬЗОВАНИЕ БАНКОВСКОЙ СИСТЕМЫ!!!");
                        System.out.println("Выход из системы...");
                        connection.close();
                        scanner.close();
                        return;
                    default:
                        System.out.println("Такого варианта нет");
                        break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}