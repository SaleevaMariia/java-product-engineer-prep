package java_core.record_examples;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class OptionalTest {

    private int counter;

    private String expensiveDefault() {
        counter++;
        return "default";
    }

    @Test
    void value() {
        assertTrue(Optional.of("abc").isPresent());
    }

    @Test
    void npe() {
        assertThrows(
                NullPointerException.class,
                () -> {
                    Optional.of(null);
                });
    }

    @Test
    void empty() {
        assertTrue(Optional.ofNullable(null).isEmpty());
    }

    @Test
    void value2() {
        assertTrue(Optional.ofNullable("abc").isPresent());
    }

    @Test
    void defaultTest() {
        assertEquals("default", Optional.empty().orElse("default"));
    }

    @Test
    void value3() {
        assertEquals("value", Optional.of("value").orElse("default"));
    }

    @Test
    void orElseShouldEvaluateDefaultEvenWhenValuePresent() {
        counter = 0;

        String result = Optional.of("value").orElse(expensiveDefault());

        assertEquals("value", result);
        assertEquals(1, counter);
    }

    @Test
    void orElseGetShouldNotEvaluateDefaultWhenValuePresent() {
        counter = 0;

        String result = Optional.of("value").orElseGet(() -> expensiveDefault());

        assertEquals("value", result);
        assertEquals(0, counter);
    }
}
