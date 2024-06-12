package org.hogwarts.annotations.test4.valid_interfaces;

import org.hogwarts.annotations.test4.valid_clases.ValidationResult;

// ПРОЕРКА ПРОСТО ОБЪЕКТОВ БЕЗ ПРИВЯЗКИ К СТРУКТУРЕ КЛАССА
// ПОЛУЧАТЬ БУДЕМ КАКОЙ ТО РЕЗУЛЬТАТ ВАЛИДАЦИИ (ValidationResult) = список поломанных полей
public interface BeanValidator {
    ValidationResult validate(Object bean);
}
