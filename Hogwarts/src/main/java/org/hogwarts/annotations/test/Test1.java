package org.hogwarts.annotations.test;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME) // ===> только с RUNTIME мы можем видеть эту аннотацию используя рефлексию
@interface SmartPhone {
    String OS() default "Android";

    int yearOfCompanyCreation() default 2010;
}

public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException {

        // ниже создаем Аннотации
        //  ===> ПОЛУЧЕНИЕ ДОСТУПА К АННОТАЦИИ с ПОМОЩЬЮ РЕФЛЕКСИИ

        Class<?> xiaomiClass = Class.forName("org.hogwarts.annotations.test.Xiaomi");
        Annotation annotation1 = xiaomiClass.getAnnotation(SmartPhone.class);
        SmartPhone sm1 = (SmartPhone) annotation1; // ===> кастим в аннотацию
        System.out.println("Annotation info from Xiaomi class: " + sm1.OS() + ", " + sm1.yearOfCompanyCreation());

        System.out.println("*******");

        Class<?> iphoneClass = Class.forName("org.hogwarts.annotations.test.Iphone");
        Annotation annotation2 = iphoneClass.getAnnotation(SmartPhone.class);
        SmartPhone sm2 = (SmartPhone) annotation2; // ===> кастим в аннотацию
        System.out.println("Annotation info from Iphone class: " + sm2.OS() + ", " + sm2.yearOfCompanyCreation());
    }

}

@SmartPhone // ===> прописаны по дефолту
class Samsung {
    String model; // ===> !!! НЕ МОЖЕМ использовать ссылочные типы данных
    double price;
}

@SmartPhone(OS = "Android", yearOfCompanyCreation = 2010) // ===>  ПЕРЕзаписываем дефолтные значения
class Xiaomi {
    String model;
    double price;
}

@SmartPhone(OS = "IOS", yearOfCompanyCreation = 1976)
class Iphone {
    String model;
    double price;
}