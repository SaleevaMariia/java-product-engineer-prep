# Immutability

Immutable object:
- state cannot change after construction

How:
- private final fields
- no setters
- validate in constructor
- no exposing mutable internals
- defensive copies for mutable inputs
- optionally final class

Money:
- value object
- equality by amount + currency
- add/multiply return new Money

Product:
- entity
- identity by id