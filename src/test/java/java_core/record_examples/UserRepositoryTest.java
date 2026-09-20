package java_core.record_examples;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    void findByIdExistingId() {
        UserRepository users = new UserRepository();
        users.save(1L, "Masha");
        assertEquals("Masha", users.findById(1L).get());
    }

    @Test
    void findByIdMissingId() {
        UserRepository users = new UserRepository();
        users.save(1L, "Masha");
        assertEquals(Optional.empty(), users.findById(2L));
    }

    @Test
    void findByIdMissingIdThrow() {
        UserRepository users = new UserRepository();
        users.save(1L, "Masha");
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    users.findById(2L).orElseThrow(() -> new IllegalArgumentException());
                }
        );
    }

    @Test
    void findByIdMap() {
        UserRepository users = new UserRepository();
        users.save(1L, "Masha");
        assertEquals("MASHA", users.findById(1L).map(String::toUpperCase).get());
    }
}