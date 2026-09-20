package java_core.record_examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaskTitleTest {

    @Test
    void validTest() {
        TaskTitle title = new TaskTitle("title");
        assertEquals("title", title.value());
    }

    @Test
    void nullTest() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new TaskTitle(null);
                }
        );

        assertEquals("Title must not be blank or null", exception.getMessage());
    }

    @Test
    void blankTest() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new TaskTitle("  ");
                }
        );

        assertEquals("Title must not be blank or null", exception.getMessage());
    }

    @Test
    void shortTest() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new TaskTitle("1");
                }
        );

        assertEquals("Length of value must be from 2 to 255", exception.getMessage());
    }

    @Test
    void longTest() {
        StringBuilder sb = new StringBuilder(256);
        for (int i = 0; i < 256; i++) {
            sb.append('A');
        }
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new TaskTitle(sb.toString());
                }
        );

        assertEquals("Length of value must be from 2 to 255", exception.getMessage());
    }
}