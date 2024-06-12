package org.hogwarts.annotations.test4.impl;

import org.hogwarts.annotations.test4.annotations.MaxLength;
import org.hogwarts.annotations.test4.exception.ValidationException;
import org.hogwarts.annotations.test4.valid_clases.BrokenField;
import org.hogwarts.annotations.test4.valid_interfaces.FieldValidator;

import java.lang.reflect.Field;

public class MaxLengthFieldValidator implements FieldValidator {
    @Override
    public BrokenField validate(Object entity, Field field) {

        if (String.class.equals(field.getType())) {
            MaxLength maxLength = field.getAnnotation(MaxLength.class);
            try {
                String fieldValue = (String) field.get(entity);
                if (fieldValue != null && fieldValue.trim().length() > maxLength.value()) {

                    return new BrokenField(field.getName(), fieldValue, "maxLength", maxLength.value());
                }
            } catch (IllegalAccessException e) {
                throw new ValidationException(e);
            }
        }
        return null;
    }
}