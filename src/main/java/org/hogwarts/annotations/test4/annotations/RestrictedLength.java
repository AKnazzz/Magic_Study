package org.hogwarts.annotations.test4.annotations;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RestrictedLength {

    int maxLength();

    int minLength() default -1;
}
