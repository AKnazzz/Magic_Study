package org.workwork.k_test_mock.homework_k7.solution.test.java.ru.productstar.mockito.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.model.Customer;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.repository.CustomerRepository;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.repository.InitRepository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerRepositoryTest {

    @Test
    public void getByNameTest() {
        CustomerRepository cr = InitRepository.getInstance().getCustomerRepository();

        assertEquals(3, cr.size());
        assertNotNull(cr.getByName("Ivan"));
        assertNull(cr.getByName("Max"));
    }

    @Test
    public void mockGetByNameTest() {
        CustomerRepository cr = mock(CustomerRepository.class);
        when(cr.getByName("Max")).thenReturn(new Customer("Max"));

        assertEquals(0, cr.size());
        assertNotNull(cr.getByName("Max"));

        when(cr.getByName(startsWith("Alex"))).then(invocationOnMock -> new Customer(invocationOnMock.getArgument(0)));
        assertNotNull(cr.getByName("Alex"));
        assertNotNull(cr.getByName("Alexey"));
        assertEquals("Alex", cr.getByName("Alex").getName());
        assertEquals("Alexey", cr.getByName("Alexey").getName());
    }
}
