# Что такое Регулярные выражения в Java?

Регулярные выражения в Java - это мощный инструмент для работы с текстом, который позволяет искать,
заменять и извлекать информацию из строк на основе заданных шаблонов.

Регулярные выражения в Java используются для проверки соответствия шаблону, определения подстрок,
которые соответствуют шаблону, и для замены этих подстрок на другие значения.

Регулярные выражения в Java основаны на синтаксисе Perl и предоставляют множество методов для работы с текстом,
включая методы для поиска и замены текста, а также методы для извлечения информации из текста.

## matches()

является одним из методов класса String в Java, который используется для проверки соответствия строки заданному
регулярному выражению.
Синтаксис метода matches() выглядит следующим образом:

```
public boolean matches(String regex)
```

где regex - это регулярное выражение, которое нужно применить к данной строке.

Метод matches() возвращает логическое значение true, если строка соответствует заданному регулярному выражению, и false
в противном случае.

Например, рассмотрим следующий код:

```
String str = "Hello, World!";
boolean result = str.matches("Hello.*");
System.out.println(result);
```

В данном примере мы используем метод matches() для проверки, начинается ли строка str с подстроки "Hello". Регулярное
выражение "Hello.*" означает, что строка должна начинаться с подстроки "Hello", за которой может следовать любой символ
или набор символов.

Результат выполнения данного кода будет true, так как строка str начинается с подстроки "Hello".

## split()

Метод split() является одним из методов класса String в Java, который используется для разбиения строки на подстроки с
использованием заданного разделителя.

Синтаксис метода split() выглядит следующим образом:

```
public String[] split(String regex)
```

где regex - это регулярное выражение, которое определяет символы, по которым нужно разбить строку.

Метод split() возвращает массив строк, содержащий подстроки, полученные путем разбиения исходной строки.

Например, рассмотрим следующий код:

```
String str = "apple,banana,orange";
String[] fruits = str.split(",");
for (String fruit : fruits) {
System.out.println(fruit);
}
```

В данном примере мы используем метод split() для разбиения строки str на подстроки, используя символ "," в качестве
разделителя. Результатом выполнения метода будет массив строк fruits, содержащий три элемента: "apple", "banana" и "
orange".

Метод split() также может использоваться с регулярными выражениями более сложной структуры. Например, следующий код
разбивает строку на подстроки, используя любую последовательность символов, состоящую из пробелов или запятых:

```
String str = "apple, banana orange";
String[] fruits = str.split("[ ,]+");
for (String fruit : fruits) {
System.out.println(fruit);
}
```

В данном примере мы используем регулярное выражение "[ ,]+" для разбиения строки на подстроки, содержащие любую
последовательность символов, состоящую из пробелов или запятых. Результатом выполнения метода будет массив строк fruits,
содержащий три элемента: "apple", "banana" и "orange".

## replace(), replaceAll(), replaceFirst()

Метод replace() является одним из методов класса String в Java, который используется для замены всех вхождений указанной
подстроки на другую подстроку.

Синтаксис метода replace() выглядит следующим образом:

```
public String replace(CharSequence target, CharSequence replacement);
```

где target - это подстрока, которую нужно заменить, а replacement - это подстрока, на которую нужно заменить все
вхождения target.

Метод replace() возвращает новую строку, полученную путем замены всех вхождений target на replacement.

Например, рассмотрим следующий код:

```
String str = "Hello, World!";
String newStr = str.replace("World", "Java");
System.out.println(newStr);
```

В данном примере мы используем метод replace() для замены подстроки "World" на подстроку "Java" в строке str.
Результатом выполнения метода будет новая строка newStr, содержащая "Hello, Java!".

Метод replace() также может использоваться с регулярными выражениями. Например, следующий код заменяет все цифры в
строке на символ "#":

```
String str = "12345";
String newStr = str.replaceAll("\\d", "#");
System.out.println(newStr);
```

В данном примере мы используем метод replaceAll() (который является аналогом метода replace(), но работает с регулярными
выражениями) для замены всех цифр в строке на символ "#". Результатом выполнения метода будет новая строка newStr,
содержащая "#####".

## Классы Pattern и Matcher

**Классы Pattern и Matcher** в Java используются для работы с регулярными выражениями. Регулярные выражения позволяют
осуществлять поиск и замену текста по заданным шаблонам.

Класс Pattern представляет собой компилированный шаблон регулярного выражения. Для создания объекта класса Pattern
используется метод compile():

```
Pattern pattern = Pattern.compile("шаблон");
```

где "шаблон" - это регулярное выражение.

**Класс Matcher** используется для поиска соответствий шаблону в тексте. Для создания объекта класса Matcher необходимо
вызвать метод matcher() у объекта класса Pattern:

```
Matcher matcher = pattern.matcher("текст для поиска");
```

Затем можно использовать методы класса Matcher для работы с найденными соответствиями. Например, метод find() ищет
следующее соответствие шаблону в тексте:

```
if (matcher.find()) {
System.out.println("Найдено соответствие");
}
```

Метод group() возвращает найденное соответствие:

```
String match = matcher.group();
```

Методы start() и end() возвращают начальную и конечную позиции найденного соответствия:

```
int start = matcher.start(); 
int end = matcher.end();
```

Пример использования классов Pattern и Matcher для поиска всех цифр в строке:

```
String text = "abc123def456";
Pattern pattern = Pattern.compile("\\d");
Matcher matcher = pattern.matcher(text);
while (matcher.find()) {
String match = matcher.group();
int start = matcher.start();
int end = matcher.end();
System.out.println("Найдено соответствие: " + match + " на позиции " + start + "-" + end);
}
```

В данном примере мы создаем объект класса Pattern для поиска всех цифр в строке. Затем создаем объект класса Matcher для
поиска соответствий шаблону в тексте. В цикле while мы используем метод find() для поиска следующего соответствия и
методы group(), start() и end() для получения информации о найденном соответствии. Результатом выполнения программы
будет вывод на консоль:

```
Найдено соответствие: 1 на позиции 3-4
Найдено соответствие: 2 на позиции 4-5
Найдено соответствие: 3 на позиции 5-6
Найдено соответствие: 4 на позиции 9-10
Найдено соответствие: 5 на позиции 10-11
Найдено соответствие: 6 на позиции 11-12
```
