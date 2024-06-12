package org.hogwarts.annotations.test2;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME) // ===> только с RUNTIME мы можем видеть эту аннотацию используя рефлексию
@interface IsLike {
    boolean isReal() default false;
}

/**
 * 1. Создать аннотацию @IsLike, применимую к классу во время выполнения
 * программы. Аннотация может хранить boolean значение.
 * <p>
 * 2. Написать метод, который рефлексивно проверит наличие аннотации @IsLike на
 * любом переданном классе и выведет значение, хранящееся в аннотации, на
 * экран.
 */
public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> likeClass = Class.forName("org.hogwarts.annotations.test2.Like");
        if (likeClass.isAnnotationPresent(IsLike.class)) {
            IsLike annotation = (IsLike) likeClass.getAnnotation(IsLike.class);
            System.out.println("Annotation info from Like class: " + annotation.isReal());
        }

//        Annotation annotation1 = likeClass.getAnnotation(IsLike.class);
//        IsLike like1 = (IsLike) annotation1; // ===> кастим в аннотацию
//        System.out.println("Annotation info from Like class: " + like1.isReal());

        System.out.println("*******");

        Class<?> dislikeClass = Class.forName("org.hogwarts.annotations.test2.Dislike");
        Annotation annotation2 = dislikeClass.getAnnotation(IsLike.class);
        IsLike dis1 = (IsLike) annotation2; // ===> кастим в аннотацию
        System.out.println("Annotation info from Dislike class: " + dis1.isReal());

    }
}

//@IsLike(isReal = true)
class Like {
    boolean isTrue;
    String email;

}

@IsLike
class Dislike {
    boolean isTrue;
    String email;
}