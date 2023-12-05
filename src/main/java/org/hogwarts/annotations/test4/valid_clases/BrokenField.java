package org.hogwarts.annotations.test4.valid_clases;

// ПОЛОМАННОЕ ПОЛЕ
public class BrokenField {
    private final String fieldName; // ИМЯ ПОЛЯ
    private final Object fieldValue; // ЗНАЧЕНИЕ ПОЛЯ
    private final String violatedRule; // ИМЯ ПРАВИЛА КОТОРОЕ БЫЛО НАРУШЕНО
    private final Object [] args; // ДОПОЛНИТЕЛЬНЫЕ АРГУМЕНТЫ

    public BrokenField(String fieldName, Object fieldValue, String violatedRule, Object[] args) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.violatedRule = violatedRule;
        this.args = args;
    }
}
