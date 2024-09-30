package org.workwork.g_spring.homework_g5.hw;

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
