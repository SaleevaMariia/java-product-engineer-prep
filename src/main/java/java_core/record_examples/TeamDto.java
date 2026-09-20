package java_core.record_examples;

import java.util.List;

public record TeamDto(List<String> members) {
    public TeamDto{
        members = List.copyOf(members);
    }
}
