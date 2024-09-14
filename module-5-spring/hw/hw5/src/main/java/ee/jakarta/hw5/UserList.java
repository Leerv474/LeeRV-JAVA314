package ee.jakarta.hw5;

import java.io.*;
import java.sql.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "userList", value = "/userList")
public class UserList extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        PrintWriter out = response.getWriter();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hw5_users", "study", "1234")) {
            String query = "select id, username, user_password from users;";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            out.println("<html><body>");
            out.println("<table>");
            out.println("<tr><th>user id</th><th>user name</th><th>user password</th></tr>");
            while (resultSet.next()) {
                out.println("<tr>");
                out.println("<td>" + resultSet.getInt(1) + "</td>>");
                out.println("<td>" + resultSet.getString(2) + "</td>");
                out.println("<td>" + resultSet.getString(3) + "</td>");
                out.printf("<td><a href='deleteURL?id=%d'>Удалить</a></td>\n", resultSet.getInt(1));
                out.printf("<td><a href='editScreen?id=%d'>Изменить</a></td>\n", resultSet.getInt(1));
                out.println("</tr>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        out.println("</table>");
        out.println("<a href='/'>Назад</a>");
        out.println("</body></html>");
    }
}