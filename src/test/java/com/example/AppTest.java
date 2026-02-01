package test.java.com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.App;

class AppTest {

    @Test
    void testMain() {
        // This executes the logic in App.java and covers the lines
        assertDoesNotThrow(() -> App.main(new String[] {}));
    }
}