package junit;

import org.junit.jupiter.api.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class AssertsExamplesTest {
    private String one = "one";
    private String equalOne = "one";

    @Test
    @DisplayName("Run assert all")
    void runAssertAll() {
        assertAll(
                () -> assertEquals(one, equalOne),
                () -> assertNotNull(one)
        );
    }

    @Test
    @DisplayName("Timeout test")
    void runTimeout() {
        String actualResult = assertTimeout(
                Duration.ofMillis(10),
                () -> {
                    return "executable result";
                }
        );

        assertEquals("executable result", actualResult);
    }

    @Test
    void thrownAssertion() {
        assertThrows(
                ArithmeticException.class,
                () -> {
                    int zero = 0;
                    int num = 10;
                    float res = num / zero;
                }
        );
    }

    @Test
    @DisplayName("Fails after 2 seconds")
    void simpleTimeout() {
        assertTimeout(
                Duration.ofMillis(100),
                () -> {
                    Thread.sleep(10);
                }
        );
    }

    @Test
    @DisplayName("Fails after 0.01 seconds")
    void preemptivelyTimeout() {
        assertTimeoutPreemptively(
                Duration.ofMillis(10),
                () -> {
                    Thread.sleep(2000);
                }
        );
    }
}
