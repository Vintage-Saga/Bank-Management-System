package com.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class Bankmandao {
    
    private String jdbcURL = "jdbc:mysql://localhost:30006/BankMan";
    private String jdbcid = "root";
    private String jdbcname = "root";
    
    private static final String INSERT_USER_SQL = "INSERT INTO Bank (id, name, dob, balance) VALUES (?, ?, ?, ?);";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM Bank WHERE id=?;";
    private static final String SELECT_ALL_USERS = "SELECT * FROM Bank;";
    private static final String DELETE_USERS_SQL = "DELETE FROM Bank WHERE id=?;";
    private static final String UPDATE_USERS_SQL = "UPDATE Bank SET id=?, name=?, dob=?, balance=? WHERE id=?;";
    
    public Bankmandao() {
        super();
    }
    
    public Connection getConnection() {
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcid, jdbcname);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public void insertUser (BankMan user) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL);
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getDob());
            preparedStatement.setString(4, user.getBalance());
            
            preparedStatement.executeUpdate();
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }

    public BankMan selectUser (int id) {
        BankMan user = null; // Start with null
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID); 
            preparedStatement.setInt(1, id);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                user = new BankMan(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("dob"), resultSet.getString("balance"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return user; // Return null if no user is found
    }
    
    public List<BankMan> selectAllBankMan() {
        List<BankMan> users = new ArrayList<>();
        
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String dob = resultSet.getString("dob");
                String balance = resultSet.getString("balance");
                
                users.add(new BankMan(id, name, dob, balance));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return users;
    }
    
    public boolean deleteUser (int id) {
        boolean status = false;
        
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1, id);
            
            status = preparedStatement.executeUpdate() > 0; // returns true if a row was affected
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}

// Ensure BankMan has the appropriate constructor
class BankMan {
    private String id;
    private String name;
    private String dob;
    private String balance;

    public BankMan(String id, String name, String dob, String balance) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.balance = balance;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}