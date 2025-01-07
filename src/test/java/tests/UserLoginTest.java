package tests;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import dao.BankDAOImpl;
import models.User;
import service.UserService;

public class UserLoginTest {
    private UserService userService;
    private BankDAOImpl bankDAO;

    @Before
    public void setUp() {
        bankDAO = mock(BankDAOImpl.class);
        userService = new UserService(bankDAO);
    }

    @Test
    public void testSuccessfulUserLogin() {
        User user = new User(1, "testuser", "password", "First", "Last", "test@example.com", null);
        when(bankDAO.getUserByUsername("testuser")).thenReturn(user); // Simulate user found
        when(user.getPassword()).thenReturn("password"); // Simulate correct password

        boolean result = userService.login("testuser", "password");
        assertTrue(result);
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        when(bankDAO.getUserByUsername("testuser")).thenReturn(null); // Simulate user not found

        boolean result = userService.login("testuser", "wrongpassword");
        assertFalse(result);
    }
}