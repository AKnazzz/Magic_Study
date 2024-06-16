package org.workwork.k_test_mock.homework_k7.solution.test.java.ru.productstar.mockito.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.model.Customer;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.repository.CustomerRepository;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.service.CustomerService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    /**
     * Тест 1 - Получение покупателя "Ivan"
     * Проверки:
     * - очередность и точное количество вызовов каждого метода из CustomerRepository
     *
     * Тест 2 - Получение покупателя "Oleg"
     * Проверки:
     * - очередность и точное количество вызовов каждого метода из CustomerRepository
     * - в метод getOrCreate была передана строка "Oleg"
     */

    @Mock
    private CustomerRepository customerRepository;

    @Test
    void testGetOrCreate_existingCustomer() {
        // Arrange
        CustomerService customerService = new CustomerService(customerRepository);
        Customer existingCustomer = new Customer("Ivan");
        when(customerRepository.getByName("Ivan")).thenReturn(existingCustomer);

        // Act
        Customer result = customerService.getOrCreate("Ivan");

        // Assert
        assertEquals(existingCustomer, result);

        // Verify
        verify(customerRepository, times(1)).getByName("Ivan");
        verify(customerRepository, never()).add(any(Customer.class));
    }

}
