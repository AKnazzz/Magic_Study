package org.hogwarts.annotations.test4.impl;

import org.hogwarts.annotations.test4.annotations.Email;
import org.hogwarts.annotations.test4.exception.ValidationException;
import org.hogwarts.annotations.test4.valid_clases.BrokenField;
import org.hogwarts.annotations.test4.valid_interfaces.FieldValidator;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

public class EmailFieldValidator implements FieldValidator {
    @Override
    public BrokenField validate(Object entity, Field field) {

        if (String.class.isAssignableFrom(field.getType())) { // => проверяем что тип поля это String
            Email annotation = field.getAnnotation(Email.class); // = берем аннотацию
            String regex = annotation.regex(); // = берем аргумент
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            try {
                String fieldValue = (String) field.get(entity);
                if (fieldValue != null
                        && !fieldValue.isEmpty()
                        && !pattern.matcher(fieldValue).find()) {
                    return new BrokenField(field.getName(), fieldValue, "email");
                }
            } catch (IllegalAccessException e) {
                throw new ValidationException(e);
            }
        }

        return null;
    }
}
