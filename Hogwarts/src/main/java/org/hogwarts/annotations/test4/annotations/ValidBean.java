package org.hogwarts.annotations.test4.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// АННОТАЦИЯ ПОМЕЧАЕТ НАШ КЛАСС И ПОЗВОЛЯЕТ ЕГО ИСПОЛЬЗОВАТЬ В НАШЕМ ВАЛИДАТОРЕ
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidBean {

    String value();
}
