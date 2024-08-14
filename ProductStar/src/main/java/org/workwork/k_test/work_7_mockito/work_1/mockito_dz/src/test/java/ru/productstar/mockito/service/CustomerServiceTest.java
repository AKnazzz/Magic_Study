package ru.productstar.mockito.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.productstar.mockito.model.Customer;
import ru.productstar.mockito.repository.CustomerRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void shouldReturnExistingCustomerIvan() {
        Customer ivan = new Customer("Ivan");
        when(customerRepository.getByName("Ivan")).thenReturn(ivan);

        Customer result = customerService.getOrCreate("Ivan");

        assertEquals("Ivan", result.getName());
        verify(customerRepository, times(1)).getByName("Ivan");
        verify(customerRepository, never()).add(any(Customer.class));
    }

    @Test
    void shouldCreateAndReturnNewCustomerOleg() {

        when(customerRepository.getByName("Oleg")).thenReturn(null);
        Customer oleg = new Customer("Oleg");
        when(customerRepository.add(any(Customer.class))).thenReturn(oleg);


        Customer result = customerService.getOrCreate("Oleg");


        assertEquals("Oleg", result.getName());

        InOrder inOrder = inOrder(customerRepository);
        inOrder.verify(customerRepository).getByName("Oleg");
        inOrder.verify(customerRepository).add(any(Customer.class));


        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerRepository).add(customerArgumentCaptor.capture());
        assertEquals("Oleg", customerArgumentCaptor.getValue().getName());
    }
}