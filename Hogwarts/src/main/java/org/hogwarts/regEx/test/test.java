package org.hogwarts.regEx.test;

/**
 *
 */
public class test {
    public static void main(String[] args) {
        String a = "1234";
        System.out.println(a.matches("1234"));

        /*
           RegExLib.com

           \\d  - одна цифра
           \\D  - одна НЕ цифра
           \\w  - одна буква, цифра или "_"
           \\W  - одна НЕ буква, НЕ цифра и НЕ "_"
           \\s  - один пробел
           \\S  - один НЕ пробел

           \\A  - выражение в начале Stringa
           \\Z  - выражение в конце Stringa
           \\b  - граница слова или числа
           \\B  - граница НЕ слова и НЕ числа


           +    - один или более (\\d+ - одно или более цифр)
           *    - ноль или более (\\d* - ноль или более цифр)  положительных!
           -    - если минус перед выражением - указывает что отрицательное
           ?    - ноль или один символов до (-?\\d* - значит символ минус "-" может как быть так и не быть)
           {n}  - n повторений
           {m,n}  - от m до n повторений
           {n,}   - n и более повторений


           (x|y|z)   - ИЛИ х или у или z = в скобках пишем вероятные вещи и разделяем их символами  |  одно из множества  (-|\\+)?\\d*  ПЕРЕД + // - ДЛЯ ЭКРАНИРОВАНИЯ

           [abc] = (a|b|c)
           [a-zA-Z]  - можно описывать большие множества
           [0-9] = \\d

           [^abc]   - символ отрицания именно в начале скобок , т.е. все символы кроме [abc]

            ^выражение  - соответствует выражению в начале строки
            выражение$  - соответствует выражению в конце строки

           .        - любой символ

           {2}      - точное количество символов ДО = 2 символа ДО (\\d{2}})
           {2, }    - 2 или более символов ДО
           {2, 4}   - от 2 до 4х символов ДО

         */

        String b = "-4564615616";
        String c = "98419463156";
        String d = "+564987489465";
        System.out.println(b.matches("(-|\\+)?\\d*"));
        System.out.println(c.matches("(-|\\+)?\\d*"));
        System.out.println(d.matches("(-|\\+)?\\d*"));


        String e = "g654985498";
        System.out.println(e.matches("[a-zA-Z]\\d+"));

        String f = "asdasd65485945";
        System.out.println(f.matches("[a-zA-Z]+\\d+"));

        String g = "21asdasd65485945";
        System.out.println(g.matches("[a-zA-Z12]+\\d+"));

        String j = "hello";
        System.out.println(j.matches("[^abc]*"));

        String h = "helloa";
        System.out.println(h.matches("[^abc]*"));

        String url = "http://www.google.com";
        String url2 = "http://www.yandex.ru";
        String url3 = "Hello where!";
        System.out.println(url.matches("http://www\\..+\\.(com|ru)"));
        System.out.println(url2.matches("http://www\\..+\\.(com|ru)"));
        System.out.println(url3.matches("http://www\\..+\\.(com|ru)"));


        String i = "123";
        System.out.println(i.matches("\\d{2,}"));

    }
}
