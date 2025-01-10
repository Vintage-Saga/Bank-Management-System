package tests;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import dao.BankDAOImpl;
import service.UserService;

public class ErrorHandlingTest {
    private UserService userService;
    private BankDAOImpl bankDAO;

    @Before
    public void setUp() {
        bankDAO = mock(BankDAOImpl.class);
        userService = new UserService(bankDAO);
    }

    @Test
    public void testUnauthorizedAccess() {
        // Simulate unauthorized access
        boolean result = userService.isAuthorized(null); // No user session
        assertFalse(result);
    }
}