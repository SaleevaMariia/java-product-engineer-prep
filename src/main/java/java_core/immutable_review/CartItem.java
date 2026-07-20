package java_core.immutable_review;

import java_core.immutable_learn.Product;

public final class CartItem {
    private final Product product;
    private final int quantity;

    public CartItem(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product must not be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public CartItem withQuantity(int newQuantity) {
        return new CartItem(this.product, newQuantity);
    }

/*    public Money getSubtotal() {
        return this.product.getPrice().multiply(this.quantity);
    }*/
}
