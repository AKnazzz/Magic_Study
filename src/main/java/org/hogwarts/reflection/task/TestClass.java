package org.hogwarts.reflection.task;

import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;

import java.util.Set;

@Slf4j
public class TestClass {

    // Получить все классы находящиеся в пакете
    // Все пакеты внутри модуля

    public static void main(String[] args) {

        Set<String> paks = TestClass.class.getModule().getPackages();

        Reflections reflections = new Reflections("org.hogwarts.reflection.task");
        Set <Class<?>> clazzez = reflections.getSubTypesOf(Object.class);

        for (Class<?> aClass : clazzez) {
            System.out.println(aClass.getName());
        }


//        for (String pak : paks) {
//            System.out.println(pak);
//        }

    }

}



// public
// private
// default ==> для родителя
// protected ==> для родителя универсальный

