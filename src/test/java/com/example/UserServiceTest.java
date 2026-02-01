package test.java.com.example;

import main.java.com.example.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void testCreateUser() {
        // void method - just verify it doesn't throw an exception
        assertDoesNotThrow(() -> userService.createUser("testUser", "test@example.com"));
    }

    @Test
    void testGetUser() {
        userService.createUser("testUser", "test@example.com");
        assertNotNull(userService.getUser("testUser"));
    }

    @Test
    void testGetUserNotFound() {
        assertNull(userService.getUser("nonExistent"));
    }

    @Test
    void testUpdateUser() {
        userService.createUser("testUser", "test@example.com");
        // void method - just verify it doesn't throw an exception
        assertDoesNotThrow(() -> userService.updateUser("testUser", "new@example.com"));
    }

    @Test
    void testDeleteUser() {
        userService.createUser("testUser", "test@example.com");
        // void method - just verify it doesn't throw an exception
        assertDoesNotThrow(() -> userService.deleteUser("testUser"));
    }

    @Test
    void testValidateEmail() {
        assertTrue(userService.validateEmail("valid@example.com"));
        assertFalse(userService.validateEmail("invalid-email"));
    }
}