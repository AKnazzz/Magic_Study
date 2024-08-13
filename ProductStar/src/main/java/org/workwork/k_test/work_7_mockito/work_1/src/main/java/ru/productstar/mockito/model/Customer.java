package org.workwork.k_test.work_7_mockito.work_1.src.main.java.ru.productstar.mockito.model;

public class Customer {
    private int id;
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
