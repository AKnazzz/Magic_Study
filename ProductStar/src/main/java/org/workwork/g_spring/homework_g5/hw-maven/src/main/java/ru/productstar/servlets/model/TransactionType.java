package ru.productstar.servlets.model;

public enum TransactionType {
    INCOME('+'), EXPENSE('-');

    private final char sign;

    TransactionType(char sign) {
        this.sign = sign;
    }

    public char getSign() {
        return sign;
    }
}
