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

@WebServlet("/deleteURL")
public class Deletion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        out.println("<html><body>");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hw5_users", "study", "1234")) {
            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int rows = preparedStatement.executeUpdate();
            if (rows == 1) {
                out.println("<h2>Удаление прошло успешно</h2>");
            } else {
                out.println("<h2>Удаление не удалось</h2>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h2>" + e.getMessage() + "</h2>");
        }
        out.println("</div></body></html>");
        resp.sendRedirect(req.getContextPath() + "/userList");
    }
}
