Конструкторы и порядок инициализации

При new B(), где B extends A:

1. Выделяется память под весь объект B.
2. Поля получают default values:
   int -> 0
   boolean -> false
   reference types -> null
3. Вызывается constructor A через super().
4. Выполняются field initializers класса B.
5. Выполняется constructor B.
6. Объект полностью создан.

Ловушка:
Если constructor A вызывает метод print(),
а B переопределяет print(),
то вызов пойдёт в B.print().

Но поля B ещё не инициализированы явно.
Поэтому:
int -> 0
Integer/String -> null

Правило:
Не вызывать переопределяемые методы из конструктора.