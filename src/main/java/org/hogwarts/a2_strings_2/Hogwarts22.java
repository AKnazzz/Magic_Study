package org.hogwarts.a2_strings_2;

import java.util.Random;

public class Hogwarts22 {
    public static void main(String[] args) {
        castSpell();

    }

    public static void castSpell() {
        //1. Создайте строку в верхнем регистре: ARDENTIS VERUM LUMINOS ET FULGUR SYLVESTRA ELIXIA.
        String spellString = "ARDENTIS VERUM LUMINOS ET FULGUR SYLVESTRA ELIXIA";

        //2. Приведите строку к нижнему регистру
        String lowercaseSpellString = spellString.toLowerCase();

        //3. Создайте случайное число int start с помощью класса Random. Число должно быть в диапазоне от 0 до 50.
        int start = new Random().nextInt(50);

        //4. Создайте подстроку от строки, содержащей слова заклинаний, которая будет начинаться с индекса, равного start.
        String subString = lowercaseSpellString.substring(start);

        //5. Создайте объект класса StringBuilder spell, запишите полученную строку выше в этот объект.
        StringBuilder spell = new StringBuilder(subString);

        //6. Разверните строку задом наперед.
        spell.reverse();

        //7. В полученной строке поменяйте местами символы под 0 и 1 индексами.
        // * (обратитесь к методу replace: сначала получите символы(одна буква или символ пробела) под этими индексами
        // с помощью метода charAt, а затем используйте их для замены). Должно получиться что-то такое:
        //
        //builder.replace(0, 1, String.valueOf(one));
        //builder.replace(1,2, String.valueOf(zero));

        char zero = spell.charAt(0);
        char one = spell.charAt(1);

        spell.setCharAt(0, one);
        spell.setCharAt(1, zero);


        //8. Полученную строку выведите на экран. Запускаем метод main.

        System.out.println(spell.toString());

        //Прочитайте заклинание! Попробуйте запустить несколько раз и посмотрите, как меняется ваше заклинание. Подумайте, почему?

    }
}
