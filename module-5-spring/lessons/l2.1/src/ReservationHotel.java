import java.sql.*;
import java.util.Scanner;

public class ReservationHotel {
    private static final String url = "jdbc:mysql://localhost:3306/hotel";
    private static final String username = "study";
    private static final String password = "1234";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            boolean keepAlive = true;
            while (keepAlive) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("СИСТЕМА БРОНИРОВАНИЯ ОТЕЛЯ");
                System.out.println("1. Бронирование");
                System.out.println("2. Просмотр бронирования");
                System.out.println("3. Уточнить номер комнаты");
                System.out.println("4. Обновить бронирование");
                System.out.println("5. Удалить бронирование");
                System.out.println("0. Выход");

                System.out.print("Введите опцию: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 0:
                        exit();
                        keepAlive = false;
                        break;
                    case 1:
                        reserveRoom(connection, scanner);
                        break;
                    case 2:
                        viewReservation(connection);
                        break;
                    case 3:
                        getRoomNumber(connection, scanner);
                        break;
                    case 4:
                        updateReservation(connection, scanner);
                        break;
                    case 5:
                        deleteReservation(connection, scanner);
                        break;
                    default:
                        System.out.println("Неправильный ввод, попробуйте снова...");
                }
            }
            statement.close();
            connection.close();
        } catch (SQLException | InterruptedException e) {
            System.err.println(e);
        }
    }

    public static void reserveRoom(Connection connection, Scanner input) {
        try {
            System.out.print("Введите имя гостя: ");
            String guestName = input.next();
            input.nextLine();
            System.out.print("Введите номер комнаты: ");
            int roomNumber = input.nextInt();
            System.out.print("Введите контактный номер: ");
            String contactNumber = input.next();
            input.nextLine();

            System.out.println(contactNumber);
            String query = String.format("insert into reservations (guest_name, room_number, contact_number) values ('%s', %d, '%s');", guestName, roomNumber, contactNumber);
            try (Statement statement = connection.createStatement()) {
                int affectsRows = statement.executeUpdate(query);

                if (affectsRows > 0) {
                    System.out.println("Бронирование успешно");
                } else {
                    System.out.println("Бронирование не удалось");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewReservation(Connection connection) {
        String query = "SELECT * FROM reservations;";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query);) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getRoomNumber(Connection connection, Scanner scanner) {
        System.out.print("Введите идентификатор бронирования: ");
        int reservationId = scanner.nextInt();
        System.out.print("Введите имя гостя: ");
        String guestName = scanner.next();

        String query = String.format("select room_number from reservations where reservations_id = %d and guest_name = '%s'", reservationId, guestName);
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query);) {
            if (resultSet.next()) {
                int roomNumber = resultSet.getInt("room_number");
                System.out.printf("Номер комнаты для идентификатора бронирования %d гостя %s: %d", reservationId, guestName, roomNumber);
            } else {
                System.out.println("Бронирования не найдено для данного идентификатора и имени гостя.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void updateReservation(Connection connection, Scanner scanner) {
        System.out.print("Введите идентификатор бронирования: ");
        int reservationId = scanner.nextInt();
        scanner.nextLine();
        if (!reservationsExists(connection, reservationId)) {
            System.out.println("Бронирование не найдено для данного идентификатора.");
            return;
        }

        System.out.print("Введите новое имя гостя: ");
        String newGuestName = scanner.nextLine();
        System.out.print("Введите новый номер комнаты: ");
        int newRoomNumber = scanner.nextInt();
        System.out.print("Введите новый контактный номер: ");
        String newContactNumber = scanner.next();

        String query = String.format("update reservations set guest_name = '%s', room_number = %d, contact_number = '%s' where reservations_id = %d", newGuestName, newRoomNumber, newContactNumber, reservationId);

        try (Statement statement = connection.createStatement()) {
            int row = statement.executeUpdate(query);
            if (row > 0) {
                System.out.println("Бронирование успешно обновлено.");
            } else {
                System.out.println("Обновление бронирования не удалось.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean reservationsExists(Connection connection, int reservationId) {
        String query = String.format("select reservations_id from reservations where reservations_id = %d", reservationId);
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query);) {
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void deleteReservation(Connection connection, Scanner scanner) {
        System.out.print("Введите идентификатор бронирования: ");
        int reservationId = scanner.nextInt();
        scanner.nextLine();
        if (!reservationsExists(connection, reservationId)) {
            System.out.println("Бронирование не найдено для данного идентификатора.");
            return;
        }

        String query = String.format("delete from reservations where reservations_id = %d", reservationId);
        try (Statement statement = connection.createStatement()) {
            int row = statement.executeUpdate(query);
            if (row > 0) {
                System.out.println("Бронирование успешно удалено.");
            } else {
                System.out.println("Удалить бронирование не удалось.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void exit() throws InterruptedException {
        System.out.println("Выход из системы");
        int i = 5;
        while (i != 0) {
            System.out.println(".");
            Thread.sleep(1000);
            i--;
        }
        System.out.println("Спасибо за использование системы бронирования");
    }
}