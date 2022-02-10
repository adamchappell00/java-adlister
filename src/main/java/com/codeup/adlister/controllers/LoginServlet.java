package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = false;
        // TODO: find a record in your database that matches the submitted password
        // TODO: make sure we find a user with that username
        User loginUser = DaoFactory.getUsersDao().findByUsername(username);
        if(loginUser != null) {
            // TODO: check the submitted password against what you have in your database
            if (loginUser.getUsername().equals(username) && loginUser.getPassword().equals(password)) {
                validAttempt = true;
            } else {
                System.out.println("Username or Password incorrect: un:" + username + ", pw: " + password);
            }
        }

        if (validAttempt) {
            // TODO: store the logged in user object in the session, instead of just the username
            request.getSession().setAttribute("user", loginUser);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}
