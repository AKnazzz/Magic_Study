package org.hogwarts.annotations.test4.impl;

import org.hogwarts.annotations.test4.exception.ValidationException;
import org.hogwarts.annotations.test4.valid_clases.BrokenField;
import org.hogwarts.annotations.test4.valid_interfaces.FieldValidator;

import java.lang.reflect.Field;
import java.util.Collection;

public class NotEmptyFieldValidator implements FieldValidator {
    @Override
    public BrokenField validate(Object entity, Field field) {

        if (Collection.class.isAssignableFrom(field.getType())) {
            try {
                Collection<?> fieldValue = (Collection<?>) field.get(entity);
                if (fieldValue == null || fieldValue.isEmpty()) {
                    return new BrokenField(field.getName(), fieldValue, "notEmpty");
                }
            } catch (IllegalAccessException e) {
                throw new ValidationException(e);
            }
        } else if (String.class.isAssignableFrom(field.getType())) {
            try {
                String fieldValue = (String) field.get(entity);
                if (fieldValue == null || fieldValue.isEmpty()) {
                    return new BrokenField(field.getName(), fieldValue, "notEmpty");
                }
            } catch (IllegalAccessException e) {
                throw new ValidationException(e);
            }
        }

        return null;
    }
}