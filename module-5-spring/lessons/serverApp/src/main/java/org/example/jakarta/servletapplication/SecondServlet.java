package org.example.jakarta.servletapplication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/second")
public class SecondServlet extends HelloServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String parameter1 = req.getParameter("param1");
        PrintWriter out = response.getWriter();
        out.println("<h1>" + parameter1 + "</h1>");

        Map<String, String[]> parameterMap = req.getParameterMap();
        parameterMap.entrySet().forEach(e -> out.println(e.getKey() + "=" + e.getValue()));
    }

}
