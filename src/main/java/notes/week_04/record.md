record

Что это:
- компактный data carrier в Java

Автоматически создаёт:
- private final fields
- constructor
- accessors: id(), title()
- equals()
- hashCode()
- toString()

Хорошо подходит для:
- DTO
- request/response
- value-like objects

Важно:
- record final
- нельзя extends другой class
- можно implements interfaces
- accessors без get
- shallow immutable, не deep immutable
- mutable поля нужно защищать defensive copy

Не лучший выбор для:
- JPA entity
- mutable domain object
- сложного lifecycle object