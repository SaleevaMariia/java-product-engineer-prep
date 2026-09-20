package java_core.record_examples;

public record TaskTitle(
        String value
) {
    public TaskTitle {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Title must not be blank or null");
        }
        value = value.trim();
        if (value.length() < 2 || value.length() > 255) {
            throw new IllegalArgumentException("Length of value must be from 2 to 255");
        }
    }
}
