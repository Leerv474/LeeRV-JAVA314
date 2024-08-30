import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/cars";
    private static final String username = "study";
    private static final String password = "1234";
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n***ДОБРО ПОЖАЛОВАТЬ***");
                System.out.println("1. Вывести все содержимое таблицы");
                System.out.println("2. Перечислить всех производителей");
                System.out.println("3. Перечислить автомобили указанного года выпуска");
                System.out.println("4. Перечислить автомобили указанного производителя");
                System.out.println("5. Перечислить автомобили указанного цвета");
                System.out.println("6. Перечислить автомобили указанного объема двигателя");
                System.out.println("7. Перечислить автомобили указанного типа автомобиля");
                System.out.println("0. Выход");

                System.out.print("\nВаш выбор: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 0:
                        System.out.println("Выход из системы");
                        connection.close();
                        scanner.close();
                        return;
                    case 1:
                        printTable(connection);
                        break;
                    case 2:
                        listProducers(connection);
                        break;
                    case 3:
                        listAutomobilesByYear(connection, scanner);
                        break;
                    case 4:
                        listAutomobilesByProducer(connection, scanner);
                        break;
                    case 5:
                        listAutomobilesByColour(connection, scanner);
                        break;
                    case 6:
                        listAutomobilesByEngineVolume(connection, scanner);
                        break;
                    case 7:
                        listAutomobilesByType(connection, scanner);
                        break;
                    default:
                        System.out.println("Неверный ввод...\n");
                        break;
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printTable(Connection connection) {
        String query = "select * from automobiles";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String producer = resultSet.getString("producer");
                String name = resultSet.getString("name");
                double engineVolume = resultSet.getDouble("engine_volume");
                int releaseYear = resultSet.getInt("release_year");
                String colour = resultSet.getString("colour");
                String carType = resultSet.getString("car_type");
                System.out.printf("| %d | %s | %s | %f | %d | %s | %s |\n", id, producer, name, engineVolume, releaseYear, colour, carType);
            }
        } catch (SQLException e) {
            System.out.println("Не удалось вывести содержимое таблицы");
            e.printStackTrace();
        }
    }

    public static void listProducers(Connection connection) {
        String query = "select producer from automobiles group by producer";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String producer = resultSet.getString("producer");
                System.out.println(producer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listAutomobilesByYear(Connection connection, Scanner scanner) {
        String query = "select * from automobiles where release_year = ?";
        System.out.print("Введите год выпуска: ");
        int releaseYear = scanner.nextInt();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, releaseYear);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String producer = resultSet.getString("producer");
                String name = resultSet.getString("name");
                double engineVolume = resultSet.getDouble("engine_volume");
                String colour = resultSet.getString("colour");
                String carType = resultSet.getString("car_type");
                System.out.printf("| %d | %s | %s | %f | %d | %s | %s |\n", id, producer, name, engineVolume, releaseYear, colour, carType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listAutomobilesByProducer(Connection connection, Scanner scanner) {
        scanner.nextLine();
        String query = "select * from automobiles where producer = ?";
        System.out.print("Введите производителя: ");
        String producer = scanner.nextLine();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, producer);
            ResultSet resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listAutomobilesByColour(Connection connection, Scanner scanner) {
        scanner.nextLine();
        String query = "select * from automobiles where colour = ? group by colour";
        System.out.print("Введите цвет: ");
        String colour = scanner.nextLine();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, colour);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String producer = resultSet.getString("producer");
                String name = resultSet.getString("name");
                double engineVolume = resultSet.getDouble("engine_volume");
                int releaseYear = resultSet.getInt("release_year");
                String carType = resultSet.getString("car_type");
                System.out.printf("| %d | %s | %s | %f | %d | %s | %s |\n", id, producer, name, engineVolume, releaseYear, colour, carType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listAutomobilesByEngineVolume(Connection connection, Scanner scanner) {
        String query = "select * from automobiles where engine_volume = ?";
        System.out.print("Введите объем двигателя: ");
        double engineVolume = scanner.nextDouble();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setDouble(1, engineVolume);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String producer = resultSet.getString("producer");
                String name = resultSet.getString("name");
                int releaseYear = resultSet.getInt("release_year");
                String colour = resultSet.getString("colour");
                String carType = resultSet.getString("car_type");
                System.out.printf("| %d | %s | %s | %f | %d | %s | %s |\n", id, producer, name, engineVolume, releaseYear, colour, carType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listAutomobilesByType(Connection connection, Scanner scanner) {
        scanner.nextLine();
        String query = "select * from automobiles where car_type = ?";
        System.out.print("Введите тип автомобиля: ");
        String carType = scanner.nextLine();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, carType);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String producer = resultSet.getString("producer");
                String name = resultSet.getString("name");
                double engineVolume = resultSet.getDouble("engine_volume");
                int releaseYear = resultSet.getInt("release_year");
                String colour = resultSet.getString("colour");
                System.out.printf("| %d | %s | %s | %f | %d | %s | %s |\n", id, producer, name, engineVolume, releaseYear, colour, carType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}