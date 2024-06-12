package org.hogwarts.annotations.test4.valid_interfaces;

import org.hogwarts.annotations.test4.valid_clases.BrokenField;

import java.lang.reflect.Field;

// ДОПОЛНИТЕЛЬНЫЙ ИНТЕРФЕЙС КОТОРЫЙ ОТВЕЧАЕТ ЗА ВАЛИДАЦИЮ КОНКРЕТНОГО ПОЛЯ
public interface FieldValidator {
    BrokenField validate(Object entity, Field field);
}
