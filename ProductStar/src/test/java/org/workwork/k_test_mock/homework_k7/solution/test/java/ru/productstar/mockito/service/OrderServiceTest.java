package org.workwork.k_test_mock.homework_k7.solution.test.java.ru.productstar.mockito.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.ProductNotFoundException;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.model.Customer;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.model.Order;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.model.Product;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.model.Stock;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.model.Warehouse;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.repository.OrderRepository;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.repository.ProductRepository;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.service.CustomerService;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.service.OrderService;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.service.WarehouseService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    /**
     * Покрыть тестами методы create и addProduct.
     * Можно использовать вызовы реальных методов.
     * <p>
     * Должны быть проверены следующие сценарии:
     * - создание ордера для существующего и нового клиента
     * - добавление существующего и несуществующего товара
     * - добавление товара в достаточном и не достаточном количестве
     * - заказ товара с быстрой доставкой
     * <p>
     * Проверки:
     * - общая сумма заказа соответствует ожидаемой
     * - корректная работа для несуществующего товара
     * - порядок и количество вызовов зависимых сервисов
     * - факт выбрасывания ProductNotFoundException
     */

    @Mock
    private CustomerService customerService;
    @Mock
    private WarehouseService warehouseService;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private OrderService orderService;

    private Customer testCustomer;
    private Order testOrder;
    private Product testProduct;
    private Warehouse testWarehouse;

    @BeforeEach
    void setUp() {
        testCustomer = new Customer("TestCustomer");
        testOrder = new Order(testCustomer);
        testProduct = new Product("TestProduct");
        testWarehouse = new Warehouse("TestWarehouse", 50);
    }

    @Test
    public void testCreateOrderForExistingCustomer() {
        when(customerService.getOrCreate("TestCustomer")).thenReturn(testCustomer);
        when(orderRepository.create(testCustomer)).thenReturn(testOrder);

        Order order = orderService.create("TestCustomer");

        assertNotNull(order);
        assertEquals(testOrder, order);
        verify(customerService).getOrCreate("TestCustomer");
        verify(orderRepository).create(testCustomer);
    }

    @Test
    public void testCreateOrderForNewCustomer() {
        when(customerService.getOrCreate("NewCustomer")).thenReturn(new Customer("NewCustomer"));
        when(orderRepository.create(any(Customer.class))).thenReturn(new Order(new Customer("NewCustomer")));

        Order order = orderService.create("NewCustomer");

        assertNotNull(order);
        verify(customerService).getOrCreate("NewCustomer");
        verify(orderRepository).create(any(Customer.class));
    }

    @Test
    public void testAddExistingProductToOrder() throws ProductNotFoundException {
        when(warehouseService.findWarehouse("TestProduct", 1)).thenReturn(testWarehouse);
        when(productRepository.getByName("TestProduct")).thenReturn(testProduct);
        when(warehouseService.getStock(testWarehouse, "TestProduct")).thenReturn(new Stock(testProduct, 10, 3));

        Order order = orderService.addProduct(testOrder, "TestProduct", 1, false);

        //assertNotNull(order);
        verify(warehouseService).findWarehouse("TestProduct", 1);
        verify(productRepository).getByName("TestProduct");
        verify(warehouseService).getStock(testWarehouse, "TestProduct");
    }

    @Test
    public void testAddNonExistingProductToOrder() {
        when(warehouseService.findWarehouse("NonExistingProduct", 1)).thenReturn(null);

        assertThrows(ProductNotFoundException.class,
                () -> orderService.addProduct(testOrder, "NonExistingProduct", 1, false));

        verify(warehouseService).findWarehouse("NonExistingProduct", 1);
        verifyNoMoreInteractions(productRepository, warehouseService);
    }


}
