package org.hogwarts.regEx.task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 1. Найти в тексте все слова с А или с а
 * 2. Все цифры в тексте заменить на символы #
 * 3. Проверить является ли строка URL
 *
 */
public class TaskRefEx2 {
    public static void main(String[] args) {

        String text = "Lorem ipsum dolor sit amet, 123 consectetur adipiscing elit. Sed ac arcu ac "
                + "tellus bibendum aliquam. Mauris auctor, justo ac fringilla ultricies, massa lacus tristique magna,"
                + " vel tincidunt augue nulla ac ex. Nullam vel libero vitae risus malesuada eleifend. "
                + "Aliquam erat volutpat. Sed eget felis in 6654 nisi luctus feugiat. Donec non dui euismod, "
                + "commodo justo eu, commodo purus. Aliquam erat volutpat. Vivamus varius tincidunt odio, "
                + "at bibendum velit. Nam in augue vitae urna 4598 tincidunt sagittis. Sed auctor semper felis, "
                + "eu tincidunt nunc lacinia vel. Fusce ut metus vel libero pretium vestibulum. Nulla facilisi. "
                + "Ut nec mauris ut mi accumsan lacinia 654654654.";

        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(text);

        String result = matcher.replaceAll("#");
        System.out.println(result);
    }

}
