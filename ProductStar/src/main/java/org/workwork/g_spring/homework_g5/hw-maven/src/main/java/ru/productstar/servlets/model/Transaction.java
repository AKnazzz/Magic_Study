package ru.productstar.servlets.model;

public class Transaction {
    private final TransactionType type;
    private final String name;
    private final int sum;

    public Transaction(TransactionType type, String name, int sum) {
        this.type = type;
        this.name = name;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public int getSum() {
        return sum;
    }

    public String getSimpleStringValue() {
        return String.format("%s%d (%s)", type.getSign(), getSum(), getName());
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type.name() + '\'' +
                "name='" + name + '\'' +
                ", sum=" + sum +
                '}';
    }
}