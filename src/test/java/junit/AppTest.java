/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package junit;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    @DisplayName("Test app has a greeting")
    void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "App should have a greeting");
    }
}
