package java_core.record_examples;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TeamDtoTest {

    @Test
    void members() {
        List<String> test = new ArrayList<>();
        test.add("1");
        TeamDto team = new TeamDto(test);
        test.add("2");
        assertFalse(team.members().contains("2"));
    }

    @Test
    void tryToAdd() {
        assertThrows(
                UnsupportedOperationException.class,
                () -> {
                    List<String> test = new ArrayList<>();
                    test.add("1");
                    TeamDto team = new TeamDto(test);
                    team.members().add("2");
                }
        );
    }
}