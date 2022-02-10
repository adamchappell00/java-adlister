package com.codeup.adlister.controllers;

import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User current = (User) request.getSession().getAttribute("user");
        if (current == null) {
            response.sendRedirect("/login");
            return;
        } else {
            String username = current.getUsername();
            request.getSession().setAttribute("username", username);
        }
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
