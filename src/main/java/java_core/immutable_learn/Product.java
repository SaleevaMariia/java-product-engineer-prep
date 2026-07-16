package java_core.immutable_learn;

public final class Product {
    private final long id;
    private final String name;
    private final Money price;

    public Product(long id, String name, Money price) {
        if (id <= 0) {
            throw new IllegalArgumentException("Id must be positive");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be null or blank");
        }
        if (price == null) {
            throw new IllegalArgumentException("Price must not be null");
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }
}
