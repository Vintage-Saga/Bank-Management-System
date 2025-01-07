package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bankmandao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/bankdb"; // Update with your database URL
    private String jdbcUsername = "root"; // Update with your database username
    private String jdbcPassword = "Kaari@2006"; // Update with your database password

    private static final String INSERT_ACCOUNT_SQL = "INSERT INTO accounts (account_number, account_holder, balance) VALUES (?, ?, ?);";
    private static final String SELECT_ACCOUNT_BY_NUMBER = "SELECT * FROM accounts WHERE account_number = ?;";
    private static final String SELECT_ALL_ACCOUNTS = "SELECT * FROM accounts;";
    private static final String DELETE_ACCOUNT_SQL = "DELETE FROM accounts WHERE account_number = ?;";
    private static final String UPDATE_ACCOUNT_SQL = "UPDATE accounts SET account_holder = ?, balance = ? WHERE account_number = ?;";

    public Bankmandao() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertAccount(Account account) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT_SQL)) {
            preparedStatement.setString(1, account.getAccountNumber());
            preparedStatement.setString(2, account.getAccountHolder());
            preparedStatement.setDouble(3, account.getBalance());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account selectAccount(String accountNumber) {
        Account account = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACCOUNT_BY_NUMBER)) {
            preparedStatement.setString(1, accountNumber);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String accountHolder = rs.getString("account_holder");
                double balance = rs.getDouble("balance");
                account = new Account(accountNumber, accountHolder, balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public List<Account> selectAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ACCOUNTS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String accountNumber = rs.getString("account_number");
                String accountHolder = rs.getString("account_holder");
                double balance = rs.getDouble("balance");
                accounts.add(new Account(accountNumber, accountHolder, balance));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public boolean deleteAccount(String accountNumber) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ACCOUNT_SQL)) {
            preparedStatement.setString(1, accountNumber);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    public boolean updateAccount(Account account) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT_SQL)) {
            preparedStatement.setString(1, account.getAccountHolder());
            preparedStatement.setDouble(2, account.getBalance());
            preparedStatement.setString(3, account.getAccountNumber());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }
}
