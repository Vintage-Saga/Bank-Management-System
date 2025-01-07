package tests;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import dao.BankDAOImpl;
import models.Account;
import service.TransactionService;

public class TransactionTest {
    private TransactionService transactionService;
    private BankDAOImpl bankDAO;

    @Before
    public void setUp() {
        bankDAO = mock(BankDAOImpl.class);
        transactionService = new TransactionService(bankDAO);
    }

    @Test
    public void testDeposit() {
        Account account = new Account(1, 1000.0, null, null);
        when(bankDAO.getAccountById(1)).thenReturn(account); // Simulate account found

        transactionService.deposit(1, 500.0); // Deposit amount
        assertEquals(1500.0, account.getBalance(), 0.01); // Check updated balance
    }

    @Test
    public void testWithdraw() {
        Account account = new Account(1, 1000.0, null, null);
        when(bankDAO.getAccountById(1)).thenReturn(account); // Simulate account found

        transactionService.withdraw(1, 300.0); // Withdraw amount
        assertEquals(700.0, account.getBalance(), 0.01); // Check updated balance
    }
}