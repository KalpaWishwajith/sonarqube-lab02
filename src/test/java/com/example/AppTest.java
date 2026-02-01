package test.java.com.example;

import main.java.com.example.App;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testMain() {
        assertDoesNotThrow(() -> App.main(new String[] {}));
    }

    @Test
    void testAppInstantiation() {
        App app = new App();
        assertNotNull(app);
    }
}