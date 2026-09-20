package java_core.record_examples;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository {
    private final Map<Long, String> usersById = new HashMap<>();

    public void save(Long id, String name) {
        usersById.put(id, name);
    }

    public Optional<String> findById(Long id) {
        return Optional.ofNullable(usersById.get(id));
    }
}
