package org.workwork.k_test.work_7_mockito.work_1.src.main.java.ru.productstar.mockito;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String product) {
        super(product + " not found");
    }
}
