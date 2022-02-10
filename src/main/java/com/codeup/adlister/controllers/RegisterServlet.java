package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO: ensure the submitted information is valid
        // Test to see if username is taken
        if(DaoFactory.getUsersDao().findByUsername(request.getParameter("username")) != null){
            System.out.println("Username is already in use" + request.getParameter("username"));
        } else {
            // Test if any input values are null
            if(request.getParameter("username") != null && request.getParameter("email") != null && request.getParameter("password") != null){
                // TODO: create a new user based off of the submitted information
                User user = new User(
                        request.getParameter("username"),
                        request.getParameter("email"),
                        request.getParameter("password")
                );
                DaoFactory.getUsersDao().insert(user);
                // TODO: if a user was successfully created, send them to their profile
                User verifyUser = DaoFactory.getUsersDao().findByUsername(user.getUsername());
                request.getSession().setAttribute("user", verifyUser);
                response.sendRedirect("/profile");
            }
        };

    }
}
