package tests;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import dao.BankDAO;
import models.Account;
import service.AccountService;

import java.util.ArrayList; // Import ArrayList
import java.util.List;

public class AccountManagementTest {
    private AccountService accountService;
    private BankDAO bankDAO;

    @Before
    public void setUp() {
        bankDAO = mock(BankDAO.class);
        accountService = new AccountService(bankDAO);
    }

    @Test
    public void testAddAccount() {
        Account newAccount = new Account(0, 1000.0, null, null);
        when(bankDAO.insertAccount(newAccount)).thenReturn(1); // Simulate successful insertion

        int result = accountService.addAccount(newAccount);
        assertEquals(1, result); // Expect successful addition
    }

    @Test
    public void testGetAllAccounts() {
        List<Account> accounts = new ArrayList<>(); // Create an ArrayList of accounts
        accounts.add(new Account(1, 1000.0, null, null));
        when(bankDAO.getAllAccounts()).thenReturn(accounts); // Simulate retrieval of accounts

        List<Account> result = accountService.getAllAccounts();
        assertNotNull(result);
        assertEquals(1, result.size()); // Expect one account
    }

    @Test
    public void testGetAccountById() {
        Account account = new Account(1, 1000.0, null, null);
        when(bankDAO.getAccountById(1)).thenReturn(account); // Simulate account found

        Account result = accountService.getAccountById(1);
        assertNotNull(result);
        assertEquals(1, result.getAccountId()); // Expect account ID to match
    }

    @Test
    public void testUpdateAccount() {
        Account account = new Account(1, 1500.0, null, null);
        when(bankDAO.updateAccount(account)).thenReturn(true); // Simulate successful update

        boolean result = accountService.updateAccount(account);
        assertTrue(result); // Expect successful update
    }

    @Test
    public void testDeleteAccount() {
        when(bankDAO.deleteAccountById(1)).thenReturn(true); // Simulate successful deletion

        boolean result = accountService.deleteAccount(1);
        assertTrue(result); // Expect successful deletion
    }
}