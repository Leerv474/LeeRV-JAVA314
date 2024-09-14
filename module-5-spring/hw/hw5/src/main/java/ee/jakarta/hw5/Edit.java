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

@WebServlet("/editURL")
public class Edit extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "update users set username = ?, user_password = ? where id = ?";
        out.println("<html><body>");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hw5_users", "study", "1234")){
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, req.getParameter("username"));
            preparedStatement.setString(2, req.getParameter("user_password"));
            preparedStatement.setInt(3, Integer.parseInt(req.getParameter("id")));
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                out.println("<h2>Success</h2>");
            } else {
                out.println("<h2>Error</h2>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.printf("<h2>%s</h2>\n", e.getMessage());
        }
        out.println("</body></html>");
        resp.sendRedirect(req.getContextPath() + "/userList");
    }
}
