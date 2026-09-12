Overload

Что:
- одно имя, разные параметры

Выбор:
- compile time
- выбирается более специфичный подходящий метод

Основано на:
- declared types аргументов

Сигнатура:
- имя + параметры

Return type:
- не участвует в перегрузке

Exceptions:
- не участвуют в перегрузке

Пример:
method(Object)
method(String)

Object x = "abc";
method(x); // method(Object)
- exact > widening > boxing > varargs

Override

Что:
- subclass заменяет реализацию метода parent/interface

Выбор:
- runtime

Основано на:
- runtime type объекта

Сигнатура:
- должна совпадать

Return type:
- такой же или covariant subtype

Access:
- нельзя сузить

Checked exceptions:
- нельзя расширить
- можно сузить или убрать

Не override:
- static methods (method hiding Static method выбирается по declared type, а не runtime type.)
- private methods (Private methods не переопределяются, потому что они не видны subclass)
- constructors (Конструкторы не наследуются и не переопределяются)

Нельзя override:
- final methods

Перегрузка — компиляция и объявленные типы.
Переопределение — выполнение и фактический тип объекта.

Overload example

Object exception = new FileNotFoundException("");
test.method(exception);

Output:
Object

Why:
Overload is resolved at compile time by declared type.
Declared type of exception is Object.
Runtime object is FileNotFoundException, but overload does not use runtime type.

If:
IOException exception = new FileNotFoundException("");
-> IOException

If:
FileNotFoundException exception = new FileNotFoundException("");
-> FileNotFoundException

If:
test.method(new FileNotFoundException(""));
-> FileNotFoundException, because expression type is FileNotFoundException and it is the most specific applicable method.