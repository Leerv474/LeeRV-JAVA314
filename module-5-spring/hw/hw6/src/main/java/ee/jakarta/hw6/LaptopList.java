package ee.jakarta.hw6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/laptopList")
public class LaptopList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String manufacturer = req.getParameter("manufacturer");
        int ssdVolume;
        try {
            ssdVolume = Integer.parseInt(req.getParameter("ssdVolume"));
        } catch (NumberFormatException e) {
            ssdVolume = -1;
        }
        String gpuType = req.getParameter("gpuType");
        String operationSystem = req.getParameter("operationSystem");
        String displayType = req.getParameter("displayType");
        String screenResolution = req.getParameter("screenResolution");
        String touchScreen = req.getParameter("touchScreen");
        String keyboardLED = req.getParameter("keyboardLED");

        String query = "select * from laptops where 1=1";
        query = query + (manufacturer.isEmpty() ? "" : " and manufacturer = '" + manufacturer + "'");
        query = query + (ssdVolume == -1 ? "" : " and ssd_volume = " + ssdVolume);
        query = query + (gpuType.isEmpty() ? "" : " and gpu_type = '" + gpuType + "'");
        query = query + (operationSystem.isEmpty() ? "" : " and operation_system = '" + operationSystem + "'");
        query = query + (displayType.isEmpty() ? "" : " and display_type = '" + displayType + "'");
        query = query + (screenResolution.isEmpty() ? "" : " and screen_resolution = '" + screenResolution + "'");
        query = query + (touchScreen.isEmpty() ? "" : " and touch_screen = " + Boolean.parseBoolean(touchScreen));
        query = query + (keyboardLED.isEmpty() ? "" : " and keyboard_led = " + Boolean.parseBoolean(keyboardLED));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        out.print("<html><head>" +
                "<link href='css/style.css' rel='stylesheet' />" +
                "</head><body><div class='listRoot'>");
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/laptopShop", "study", "1234")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);


            out.println("<div class='container'>");
            out.println("<h2>СПИСОК НОУТБУКОВ</h2>");

            while (resultSet.next()) {
                out.println("<div class='listLine'>");
                out.printf("<p>%s</p>\n", resultSet.getString("manufacturer"));
                out.printf("<h3>%s</h3>\n", resultSet.getString("laptop_name"));
                out.println("</div>");
            }
            out.println("<table>");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(query);
        }
        out.println("</div></div>");
        out.print("<a href='/' class='reset'>Назад</a>");
        out.print("</body></html>");
    }
}
