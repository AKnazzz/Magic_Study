package org.productstar.mockito.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.productstar.mockito.model.Customer;
import org.productstar.mockito.repository.CustomerRepository;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


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

    @Test
    void testGetOrCreate_newCustomer() {
        // Arrange
        CustomerService customerService = new CustomerService(customerRepository);
        Customer newCustomer = new Customer("Oleg");
        when(customerRepository.getByName("Oleg")).thenReturn(null);
        when(customerRepository.add(any(Customer.class))).thenReturn(newCustomer);

        // Act
        Customer result = customerService.getOrCreate("Oleg");

        // Assert
        assertEquals(newCustomer, result);

        // Verify
        InOrder inOrder = inOrder(customerRepository);
        inOrder.verify(customerRepository, times(1)).getByName("Oleg");
        inOrder.verify(customerRepository, times(1)).add(any(Customer.class));
    }

}