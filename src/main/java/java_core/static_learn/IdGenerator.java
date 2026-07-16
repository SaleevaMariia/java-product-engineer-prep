package java_core.static_learn;

public class IdGenerator {
    private long nextId = 1;

    public long nextId() {
        return nextId++;
    }
}
