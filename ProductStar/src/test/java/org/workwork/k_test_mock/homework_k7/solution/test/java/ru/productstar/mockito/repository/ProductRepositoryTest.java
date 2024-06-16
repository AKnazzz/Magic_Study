package org.workwork.k_test_mock.homework_k7.solution.test.java.ru.productstar.mockito.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.MockedConstruction;
import org.mockito.junit.jupiter.MockitoExtension;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.model.Product;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.repository.ProductRepository;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {

    @Test
    public void mockGetByNameTest() {
        try (MockedConstruction<ProductRepository> mock = mockConstruction(ProductRepository.class)) {
            ProductRepository productRepository = new ProductRepository();
            when(productRepository.getByName("tv")).thenReturn(new Product("tv"));

            assertEquals(0, productRepository.size());
            assertNotNull(productRepository.getByName("tv"));
            assertNull(productRepository.getByName("laptop"));
        }
    }
}
