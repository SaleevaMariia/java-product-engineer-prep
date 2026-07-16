package java_core.immutable_learn;

public final class Product {
    private final long id;
    private final String name;
    private final Money price;

    public Product(long id, String name, Money price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name shouldn't be null or blank");
        }
        if (price == null) {
            throw new IllegalArgumentException("Price shouldn't be null");
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public Money getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
