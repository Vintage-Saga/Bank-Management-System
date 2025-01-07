package tests;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import dao.BankDAOImpl;
import models.User;
import models.Role;
import service.UserService;

public class UserRegistrationTest {
    private UserService userService;
    private BankDAOImpl bankDAO;

    @Before
    public void setUp() {
        bankDAO = mock(BankDAOImpl.class);
        userService = new UserService(bankDAO);
    }

    @Test
    public void testSuccessfulUserRegistration() {
        User newUser  = new User(0, "testuser", "password", "First", "Last", "test@example.com", new Role(1, "User  Role"));
        when(bankDAO.insertUser (newUser )).thenReturn(1); // Simulate successful insertion

        int result = userService.registerUser (newUser );
        assertEquals(1, result);
    }

    @Test
    public void testRegistrationWithExistingUsername() {
        User existingUser  = new User(0, "existinguser", "password", "First", "Last", "test@example.com", new Role(1, "User  Role"));
        when(bankDAO.getUserByUsername("existinguser")).thenReturn(existingUser ); // Simulate existing user

        User newUser  = new User(0, "existinguser", "password", "First", "Last", "test@example.com", new Role(1, "User  Role"));
        int result = userService.registerUser (newUser );
        assertEquals(0, result); // Assuming 0 indicates failure
    }
}