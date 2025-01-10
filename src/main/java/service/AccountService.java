package service;

import dao.BankDAO;
import models.Account;

import java.util.List;

public class AccountService {
    private BankDAO bankDAO;

    public AccountService(BankDAO bankDAO) {
        this.bankDAO = bankDAO;
    }

    public int addAccount(Account account) {
        return bankDAO.insertAccount(account); // Insert new account
    }

    public List<Account> getAllAccounts() {
        return bankDAO.getAllAccounts(); // Retrieve all accounts
    }

    public Account getAccountById(int accountId) {
        return bankDAO.getAccountById(accountId); // Retrieve account by ID
    }

    public void updateAccount(Account account) {
        return; // Update account details
    }

    public void deleteAccount(int accountId) {
        return; // Delete account by ID
    }
}