# Cart Domain Model

Money:
- immutable value object
- handles money operations

Product:
- immutable entity-like model
- has id, name, price

CartItem:
- immutable
- product + quantity
- quantity > 0
- subtotal = product.price * quantity

Cart:
- mutable
- owns collection of CartItems
- stores items in Map<Long, CartItem>
- addProduct adds quantity
- changeQuantity replaces quantity
- getItems returns copy
- getTotal accumulates immutable Money with reassignment