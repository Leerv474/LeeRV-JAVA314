package com.user.servlet;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/userLogin")
public class UserAuthorization extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        UserDao userDao = new UserDao(DBConnect.getConn());
        User userObj= userDao.login(email, password);

        if (userObj == null) {
            session.setAttribute("errorMsg", "Некорректный email или пароль");
            resp.sendRedirect("user_login.jsp");
            return;
        }

        session.setAttribute("userObj", userObj);
        resp.sendRedirect("user/index.jsp");
    }
}