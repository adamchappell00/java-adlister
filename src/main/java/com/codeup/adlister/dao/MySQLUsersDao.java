package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users{
    private Connection connection = null;

    public MySQLUsersDao(Config config){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }
    public User findByUsername(String username){
        String userQuery = "SELECT * FROM users WHERE username = ?";
        //String usernameIn = "'"+username+"'";
        PreparedStatement stmt = null;
        User resultUser = null;
        try {
            stmt = connection.prepareStatement(userQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,username );
            ResultSet rs = stmt.executeQuery();
            rs.next();
            resultUser = new User(rs.getInt("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultUser;
    }
    public Long insert(User user){
        try {
            String insertUser = "INSERT INTO users(username,email,password) VALUES(?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2,user.getEmail());
            stmt.setString(3,user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }
}
