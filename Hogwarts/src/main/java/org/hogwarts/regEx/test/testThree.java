package org.hogwarts.regEx.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testThree {
    public static void main(String[] args) {

        String text = "Hpasojd askdjlka aksldkalks mail@gmail.com alskdlkjsad lkjalsdk jlasldkjlasd laskdjlka " +
                "sjdslkdajkasdjlkasjdlkajsd yandex@yandex.ru sdf dsf df sdf asfdsfsd";

        Pattern email = Pattern.compile(
                "\\w+@(gmail|yandex)\\.(com|ru)"); // => представляет собой компилированный шаблон регулярного выражения
        Matcher matcher = email.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }

}
