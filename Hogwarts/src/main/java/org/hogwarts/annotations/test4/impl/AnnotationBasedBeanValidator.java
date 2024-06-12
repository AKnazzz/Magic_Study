package org.hogwarts.annotations.test4.impl;

import org.hogwarts.annotations.test4.annotations.ValidBean;
import org.hogwarts.annotations.test4.exception.ValidationException;
import org.hogwarts.annotations.test4.valid_clases.BrokenField;
import org.hogwarts.annotations.test4.valid_clases.ValidationResult;
import org.hogwarts.annotations.test4.valid_interfaces.BeanValidator;
import org.hogwarts.annotations.test4.valid_interfaces.FieldValidator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class AnnotationBasedBeanValidator implements BeanValidator {

    private final Map<Class<? extends Annotation>, FieldValidator> validationFunctions;
    private final Set<Class<? extends Annotation>> supportedFieldAnnotations;

    public AnnotationBasedBeanValidator(Map<Class<? extends Annotation>, FieldValidator> validationFunctions) {
        this.validationFunctions = validationFunctions;
        supportedFieldAnnotations = this.validationFunctions.keySet();
    }

    // ПРИНИМАЕТ ОБЪЕКТ И ВОЗВРАЩАЕТ РЕЗУЛЬТАТ
    // ПОДДЕРЖИВАЕМЫЕ АННОТАЦИИ ДОБАВЛЯЕМ ЧЕРЕЗ КОНСТРУКТОР

    @Override
    public ValidationResult validate(Object bean) {

        ValidationResult validationResult = new ValidationResult();


        // проверяем что не NULL

        if (bean == null) {
            throw new ValidationException("Passed bean is null");
        }


        // проверяем что есть аннотация, которая позволяет понять что это наш объект (ValidBean)

        Class<?> clazz = bean.getClass();
        if (!clazz.isAnnotationPresent(ValidBean.class)) {
            String msg = MessageFormat.format("{0} does not have the {1} annotation.",
                    clazz, ValidBean.class.getName());
            throw new ValidationException(msg);
        }

        // Берем все поля и проверяем каждое +
        // ставим флаг доступности для каждого поля
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);

            // с помощью StreamApi проходим по полям и проверяем помечено ли поле нашей аннотацией
            // после берём конкретный валидатор в зависимости от аннотации и проверяем поле валидатором
            // фильтруем результат и собираем его в список
            List<BrokenField> brokenFields = supportedFieldAnnotations.stream()
                    .filter(field::isAnnotationPresent)
                    .map(validationFunctions::get)
                    .map(fieldValidator -> fieldValidator.validate(bean, field))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            validationResult.addBrokenFields(brokenFields);
        }

        return validationResult; // ==> конечные результат ошибок всех полей
    }
}