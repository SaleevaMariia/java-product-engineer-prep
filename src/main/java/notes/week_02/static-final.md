# Static and Final

## Instance field
- belongs to object instance
- each object has its own value

## Static field
- belongs to class
- shared by all instances

## Static mutable state risks
- global shared state
- harder to test
- order-dependent tests
- race conditions in concurrency

## final reference
- reference cannot be reassigned
- object may still be mutable

Example:
final List<String> list = new ArrayList<>();
list.add("A"); // ok
list = new ArrayList<>(); // compile error