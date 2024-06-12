package org.hogwarts.a1_types_of_variables_1;

public class Homework2 {
    public static void main(String[] args) {

        // создать по 4 переменные всех цельночисленных типов данных в разных системах счислений:

        // двоичная
        // восьмиричная
        // десятичная
        // шестнадцатиричная


        byte a2 = 0B1100;   // 0B%
        byte a8 = 014;      //0%
        byte a10 = 12;
        byte a16 = 0xC;     //0x%

        System.out.println(a2);
        System.out.println(a8);
        System.out.println(a10);
        System.out.println(a16);

        short b2 = -0B010100010100;
        short b8 = -02424;
        short b10 = -1300;
        short b16 = -0x514;

        System.out.println(b2);
        System.out.println(b8);
        System.out.println(b10);
        System.out.println(b16);


        int c2 = 0B0;
        int c8 = 00;
        int c10 = 0;
        int c16 = 0x0;

        System.out.println(c2);
        System.out.println(c8);
        System.out.println(c10);
        System.out.println(c16);


        long d2 = 0B0111010110111100110100010101L;
        long d8 = 0726746425L;
        long d10 = 123456789L;
        long d16 = 0x75BCD15L;

        System.out.println(d2);
        System.out.println(d8);
        System.out.println(d10);
        System.out.println(d16);


        // Создать по 2шт - float, double и boolean

        float f1 = 3.14f;
        float f2 = 2.5414f;

        System.out.println(f1);
        System.out.println(f2);

        double f3 = 0.123D;
        double f4 = 11232.23123D;

        System.out.println(f3);
        System.out.println(f4);

        boolean bool1 = true;
        boolean bool2 = false;

        System.out.println(bool1);
        System.out.println(bool2);


        // Создать char всем способами

        char ch1 = 'z';         // ===> присваивания символа 'z' типу char
        char ch2 = '\u0555';    // ===> присваивания символа '0̆555' (код Unicode) типу char
        char ch3 = 7177;         // ===>  присваивания числового значения 777 типу char, что возможно благодаря тому,
        // что тип char может хранить числовые значения, соответствующие кодам Unicode.

        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(ch3);

        for (int i = 0; i <= 256; i++) { // ===> вывести весь алфавит
            System.out.println((char) i);
        }


    }
}
