package org.hogwarts.annotations.test4;

public class BrokenField {
    private final String fieldName;
    private final Object fieldValue;
    private final String violatedRule;
    private final Object [] args;

    public BrokenField(String fieldName, Object fieldValue, String violatedRule, Object[] args) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.violatedRule = violatedRule;
        this.args = args;
    }
}
