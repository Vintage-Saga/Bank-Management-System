package service;

import dao.BankDAO;
import models.Account;

public class TransactionService {
    private BankDAO bankDAO;

    public TransactionService(BankDAO bankDAO) {
        this.bankDAO = bankDAO;
    }

    public boolean deposit(int accountId, double amount) {
        Account account = bankDAO.getAccountById(accountId);
        if (account != null && amount > 0) {
            account.setBalance(account.getBalance() + amount); // Update balance
            return bankDAO.updateAccount(account); // Persist changes
        }
        return false; // Invalid account or amount
    }

    public boolean withdraw(int accountId, double amount) {
        Account account = bankDAO.getAccountById(accountId);
        if (account != null && amount > 0 && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount); // Update balance
            return bankDAO.updateAccount(account); // Persist changes
        }
        return false; // Invalid account, amount, or insufficient funds
    }
}