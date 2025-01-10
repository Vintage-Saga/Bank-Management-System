package service;

import dao.BankDAO;
import models.User;

public class UserService {
    private BankDAO bankDAO;

    public UserService(BankDAO bankDAO) {
        this.bankDAO = bankDAO;
    }

    public int registerUser (User user) {
        if (bankDAO.getUserByUsername(user.getUsername()) != null) {
            return 0; // Username already exists
        }
        return bankDAO.insertUser (user); // Insert new user
    }

    public boolean login(String username, String password) {
        User user = bankDAO.getUserByUsername(username);
        return user != null && user.getPassword().equals(password); // Successful login
    }

    public boolean isAuthorized(User user) {
        return user != null; // Simple check for authorization
    }
}