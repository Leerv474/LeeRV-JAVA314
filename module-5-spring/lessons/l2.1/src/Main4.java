import java.sql.*;

public class Main4 {
    public static void main(String[] args) {
        final String url = "jdbc:mysql://localhost:3306/hotel";
        final String username = "study";
        final String password = "1234";

        String withdrawQuery = "update accounts set balance = balance - ? where account_number = ?;";
        String depositQuery = "update accounts set balance = balance + ? where account_number = ?;";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            try {
                PreparedStatement withdrawStatement = connection.prepareStatement(withdrawQuery);
                PreparedStatement depositStatement = connection.prepareStatement(depositQuery);

                withdrawStatement.setDouble(1, 500);
                withdrawStatement.setString(2, "account1");

                depositStatement.setDouble(1, 500);
                depositStatement.setString(2, "account2");

                withdrawStatement.executeUpdate();
                depositStatement.executeUpdate();
                connection.commit();
                System.out.println("Транзакция прошла успешно");
            } catch (SQLException e) {
                connection.rollback();
                System.out.println("Транзация не удалась");
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}