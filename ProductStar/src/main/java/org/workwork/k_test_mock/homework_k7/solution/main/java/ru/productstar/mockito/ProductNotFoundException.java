package org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String product) {
        super(product + " not found");
    }
}
