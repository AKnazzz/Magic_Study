package org.workwork.b_java_objects.homework_b8.stock;

public class Stock {

    private static Stock[] stocks = new Stock[10];
    private String name;

    public Stock(String name) {
        this.name = name;
    }

    public static void initDB() {
        stocks[0] = new Stock("утюг");
        stocks[1] = new Stock("сковородка");
        stocks[2] = new Stock("лыжи");
        stocks[3] = new Stock("утюг2");
        stocks[4] = new Stock("пылесос");
    }

    public static void showAll() {
        System.out.println("Показать всех: ");
        for (Stock stock : stocks) {
            System.out.println(stock);
        }
    }

    public static void main(String[] args) {
        initDB();
        showAll();
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "\nName: " + this.getName();
    }
}