Optional<T>

Что это:
- контейнер для значения, которое может отсутствовать

Зачем:
- явно показать отсутствие результата
- уменьшить риск NPE
- заставить caller обработать empty case

Создание:
Optional.of(value)        // value must not be null
Optional.ofNullable(v)   // v may be null
Optional.empty()

Методы:
orElseThrow()
orElse()
orElseGet()
map()
filter()
ifPresent()

Типичное использование:
Optional<Task> findById(Long id)

Избегать:
- Optional fields
- Optional parameters
- optional.get() без проверки

Важно:
orElse(value) — value вычисляется сразу
orElseGet(() -> value) — value вычисляется лениво

Optional чаще всего используют как return type.

Хорошо:
Optional<Task> findById(Long id)

Почему:
- явно показывает, что результата может не быть
- заставляет caller обработать empty case

Плохо как field:
private Optional<String> title;
- усложняет модель
- плохо для JPA/serialization
- Optional field сам может быть null
- лишняя обёртка

Плохо как parameter:
void update(Optional<String> title)
- caller должен сам создавать Optional
- API становится шумным
- лучше overload, nullable DTO field или отдельный command object