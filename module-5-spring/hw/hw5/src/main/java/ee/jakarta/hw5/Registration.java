package ee.jakarta.hw5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/registration")
public class Registration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hw5_users", "study", "1234")){
            String query = "insert into users (username, user_password) values (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            int rows = preparedStatement.executeUpdate();

            out.println("<html><body><div>");
            if (rows > 0) {
                out.println("<p>Регистрация успешна</p>");
            } else {
                out.println("<p>Регистрация не удалась</p>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<p>" + e.getMessage() + "</p>");
        }
        out.println("</div></body></html>");
        resp.sendRedirect(req.getContextPath() + "/");
    }
}