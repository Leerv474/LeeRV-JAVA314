package org.ee.jakarta.bookwebapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/editScreen")
public class EditScreenServlet extends HttpServlet {
    protected static final String query = "SELECT book_title, book_edition, book_price FROM book_data WHERE id = ?";

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

        out.println("<html><head><link rel='stylesheet' href='css/style.css'></head><body><div class='list'>");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book_app", "study", "1234")) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            out.println("<form action='editURL?id="+id+"'method='post'>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td>Название книги</td>");
            out.printf("<td><input type='text' name='bookTitle' value='%s'</td>\n", resultSet.getString(1));
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Название книги</td>");
            out.printf("<td><input type='text' name='bookEdition' value='%s'</td>\n", resultSet.getString(2));
            out.println("</tr>");

            out.println("<tr>");
            out.println("<td>Название книги</td>");
            out.printf("<td><input type='text' name='bookPrice' value='%f'</td>\n", resultSet.getFloat(3));
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><input type='submit' value='Изменить' class='submit'></td>");
            out.println("<td><input type='reset' value='Отменить' class='submit'></td>");
            out.println("</tr>");

            out.println("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<h2>" + e.getMessage() + "</h2>");
        }
        out.println("<a href='home.html'>Главная</a>");
        out.println("</div></body></html>");
    }
}