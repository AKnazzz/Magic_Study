package org.hogwarts.annotations.test4.impl;

import org.hogwarts.annotations.test4.annotations.MinLength;
import org.hogwarts.annotations.test4.exception.ValidationException;
import org.hogwarts.annotations.test4.valid_clases.BrokenField;
import org.hogwarts.annotations.test4.valid_interfaces.FieldValidator;

import java.lang.reflect.Field;

public class MinLengthFieldValidator implements FieldValidator {
    @Override
    public BrokenField validate(Object entity, Field field) {

        if (String.class.equals(field.getType())) {
            MinLength minLength = field.getAnnotation(MinLength.class);
            try {
                String fieldValue = (String) field.get(entity);
                if (fieldValue != null && fieldValue.trim().length() < minLength.value()) {

                    return new BrokenField(field.getName(), fieldValue, "minLength", minLength.value());
                }
            } catch (IllegalAccessException e) {
                throw new ValidationException(e);
            }
        }
        return null;
    }
}