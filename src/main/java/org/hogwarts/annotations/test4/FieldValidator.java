package org.hogwarts.annotations.test4;

import java.lang.reflect.Field;

public interface FieldValidator {
    BrokenField validate(Object entity, Field field);
}
