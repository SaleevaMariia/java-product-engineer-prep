package java_core.immutable_learn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private final Map<Long, CartItem> itemsByProductId = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product must not be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        CartItem existingItem = itemsByProductId.get(product.getId());

        if (existingItem == null) {
            itemsByProductId.put(product.getId(), new CartItem(product, quantity));
        } else {
            int newQuantity = existingItem.getQuantity() + quantity;
            itemsByProductId.put(product.getId(), existingItem.withQuantity(newQuantity));
        }

    }

    public void removeProduct(long productId) {
        this.itemsByProductId.remove(productId);
    }

    public void changeQuantity(long productId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        CartItem existingItem = itemsByProductId.get(productId);

        if (existingItem == null) {
            throw new IllegalArgumentException("Product not found in cart: " + productId);
        }

        itemsByProductId.put(productId, existingItem.withQuantity(quantity));
    }

    public List<CartItem> getItems() {
        return List.copyOf(this.itemsByProductId.values());
    }

    public Money getTotal(String currency) {
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Currency must not be null or empty");
        }
        Money result = new Money(0, currency);
        for (CartItem cartItem : this.itemsByProductId.values()) {
            result = result.add(cartItem.getSubtotal());
        }
        return result;
    }

    public void clear() {
        this.itemsByProductId.clear();
    }
}
