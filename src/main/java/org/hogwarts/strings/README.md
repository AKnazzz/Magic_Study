# Строки

String - это класс в Java, который представляет собой последовательность символов. В этом классе есть множество методов для работы со строками. Рассмотрим некоторые из них:

## 1. Сравнение строк equals
Сравнение через == вернет нам true, если сравниваемые строки лежат по одному адресу.

```
String s1 = "Wingardium Leviosa";
String s2 = "Wingardium" + " " + "Leviosa";
String s3 = "Wingardium Leviosa Wingardium Leviosa";`

// Получим true
System.out.println(s1.equals(s2));
// Получим false
System.out.println(s1.equals(s3));
```

## 2. length() - возвращает длину строки:

```
String str = "Bombarda Maxima!"
// Получим 16. Пробелы и символы - считаются!
System.out.println(str.length());
```

## 3. charAt(int index) - возвращает символ по указанному индексу:

```
String charm = "CHARM";

// Получим 'C'
System.out.println(charm.charAt(0));

// Получим 'M'
System.out.println(charm.charAt(4));

// Получим ошибку, так как в строке нет символа под номером 8
System.out.println(charm.charAt(8));
// Получим ошибку, так как не поддерживаются отрицательные индексы
System.out.println(charm.charAt(-1));
```

## 4. Метод сравнения начала и конца строки: startsWith, endsWith.
```
String charm = "Bombarda Maxima!";

// Получим true
boolean charmStart1 = charm.startsWith("Bom");
// Получим false
boolean charmStart2 = charm.startsWith("ard");

// Получим true
boolean charmEnd1 = charm.endsWith("xima!");
// Получим false
boolean charmEnd2 = charm.endsWith("Max");
```

## 5. Метод получения подстроки: indexOf, contains.

```
String charm = "Bombarda Maxima!";

// Получим 9, начиная с 9-го символа в строке содержится "Maxima"
System.out.println(charm.indexOf("Maxima"));
// Получим -1, потому что такой подстроки нет
System.out.println(charm.indexOf("schooooooool"));

// contains вернёт true, если подстрока содержится в строке
System.out.println(charm.contains("Bom"));
// contains вернёт false, если подстрока НЕ содержится в строке
System.out.println(charm.contains("Bum"));
```

## 6. Методы замены подстроки: replace, replaceAll.

```
String charm = "Bombarda Maxima!";
String result1 = charm.replace("Bombarda", "Wow!"); // заменяет "Bombarda" на "Wow!"
System.out.println(result1); // получим "Wow! Maxima!"

String result2 = charm.replaceAll("a", "0"); // заменяет все a в строке charm на 0
System.out.println(result2); // получим "Bomb0rd0 M0xim0!"
```

## 7. Методы проверки строки на пустоту: isEmpty, isBlank.

В чем разница? **isEmpty** проверит, что строка вообще пустая. То есть выглядит вот так: **“”**. 
Внутри кавычек вообще ничего нет. И если строка действительно такая, то вернет **true**.

**isBlank** вернет **true**, если строка пустая — **“”** или если содержит только пробельные символы: **“ “**.
```
String s1 = " _ ";
String s2 = "\\t      \\n";
String s3 = "";

// Получим false и false
System.out.println(s1.isBlank());
System.out.println(s1.isEmpty());

// Получим true и false
System.out.println(s2.isBlank());
System.out.println(s2.isEmpty());

// Получим true и true
System.out.println(s3.isBlank());
System.out.println(s3.isEmpty());

```

## 8. toUpperCase() - преобразует строку к верхнему регистру:
##  toLowerCase() - преобразует строку к нижнему регистру:
 
```
String s1 = "REDUCIO";
String s2 = "inflatus";

// Получится "reducio"
System.out.println(s1.toLowerCase());
// Получится "INFLATUS";
System.out.println(s2.toUpperCase());
 ```

## 9. Метод получения подстроки: substring.
```
String str = "123456";

// Левая граница включительно, правая не включительно
String result1 = str.substring(1, 5);
// Получим строку "2345"
System.out.println(result1);

// Начиная со второго индекса
String result2 = str.substring(2);
// Получим строку "3456"
System.out.println(result2);
```
💡 Индексация всегда начинается с нуля!

Обратите внимание, что ко всем этим методам мы обращаемся именно через имя строки. 
То есть обращаемся к конкретному объекту, и у него вызываем нужный метод. 
Но это еще не все! Мы можем обратиться к самому классу String и посмотреть его 
методы тоже.

## 10. String.valueOf() превращает число или символ в строку:

```
// Получим строку из 2-х рандомных чисел
// Результат сложения строки с числом – строка, не число
String initial = String.valueOf(50) + 11;
```
Что здесь происходит? Сначала 50 из числа превращается в строку, а затем к этой строке мы прибавляем 11. 
Если попытаться к любой строке прибавить число, то получится строка. Поэтому результат этого выражения будет 5011, 
а не 61. Хе-хе.

## 11. String.join() соединяет несколько строк через разделитель:
```
// Соединяем строки через пробел
// Первый аргумент метода – разделитель (передаем пробел)
String result1 = String.join(" ", "Bombarda", "Maxima", "!");
// Получим строку "Bombarda Maxima !"
System.out.println(result1);

String result2 = String.join(", ", "1", "2", "3", "4", "5");
// Получим строку "1, 2, 3, 4, 5"
System.out.println(result2);
```
## 12. String.format() форматирует строку:
```
String res1 = String.format("Строка - %s, Число - %d", "Accio", 42);
// Получим "Строка - Accio, Число - 42"
System.out.println(res1);
```
**%s — представление строки, %d — представление числа.**


# StringBuilder

Как мы уже сказали выше, когда мы складываем строки, то для суммарной строки всегда создается новая строка, 
то есть выделяется дополнительная память. Чтобы не засорять память компьютера огромным количеством разных строк, 
придумали StringBuilder. Это класс с удобными методами, который позволяет эффективно манипулировать строками.

```
// Создаём StringBuilder
StringBuilder builder = new StringBuilder();

// Друг за другом можно добавлять строки или числа в конец строки
builder.append("Wingardium ")
        .append("Leviosa");

// builder.toString() вернёт получившуюся строку
String result = builder.toString();
// Wingardium Leviosa
System.out.println(result);
```
В чём же секрет? Разве StringBuilder не оперирует теми же строками, которые создаются каждый раз? 
Оказывается, StringBuilder создаёт внутри себя большой массив, внутри которого можно просто 
менять значения конкретного индекса. Идея в том, что этот массив выделяется один раз большой, 
и если в коде нужно создать большую строку в цикле, тогда можно воспользоваться StringBuilder 
что бы оптимизировать процесс.


Так же как у String, у StringBuilder есть разные методы для управления строкой, перечислим наиболее популярные:

## indexOf — возвращает индекс подстроки, или -1 если не содержится;
## substring — возвращает подстроку;
## equals — сравнивает строки внутри StringBuilder;
## replace — заменяет подстроку.**

```
StringBuilder sb = new StringBuilder("Wingardium Leviosa");
// Границы строки и то, на что нужно заменить подстроку
sb.replace(0, 9, "123456789");

// Получим "123456789 Leviosa"
System.out.println(sb);
```
## reverse переворачивает строку:
```
StringBuilder builder = new StringBuilder();
builder.append("123")
        .append(456);

// Метод перевернёт строку внутри StringBuilder
builder.reverse();
String result = builder.toString();

// Получим строку "654321"
System.out.println(result);
```
## deleteCharAt — удаляет конкретный символ под индексом;
## delete — удаляет подстроку:

```
StringBuilder charm = new StringBuilder("Accio");
// Указываем границы подстроки для удаления
charm.delete(1, 3);
// Получим "Aio" - начало включительно, конец - нет!
System.out.println(charm);

charm.deleteCharAt(0);
charm.deleteCharAt(1);
// Получим "i". Обратите внимание, результат предыдущих операций сохраняется
System.out.println(charm);
```
Обратите внимание, методы модификации строки у StringBuilder не возвращают результат, например reverse, delete, 
deleteCharAt, replace. В отличие от String, где результат тут же возвращается, потому что нельзя поменять строку, создаётся каждый раз новая.













