package ru.productstar.mockito.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.productstar.mockito.ProductNotFoundException;
import ru.productstar.mockito.model.Customer;
import ru.productstar.mockito.model.Delivery;
import ru.productstar.mockito.model.Order;
import ru.productstar.mockito.model.Product;
import ru.productstar.mockito.model.Stock;
import ru.productstar.mockito.model.Warehouse;
import ru.productstar.mockito.repository.OrderRepository;
import ru.productstar.mockito.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

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

    @Test
    void testCreateOrderForExistingCustomer() {
        String customerName = "John Doe";
        Customer customer = new Customer(customerName);
        Order order = new Order(customer);

        when(customerService.getOrCreate(customerName)).thenReturn(customer);
        when(orderRepository.create(customer)).thenReturn(order);

        Order createdOrder = orderService.create(customerName);

        assertEquals(order, createdOrder);
        verify(customerService, times(1)).getOrCreate(customerName);
        verify(orderRepository, times(1)).create(customer);
    }

    @Test
    void testCreateOrderForNewCustomer() {
        String customerName = "Jane Doe";
        Customer customer = new Customer(customerName);
        Order order = new Order(customer);

        when(customerService.getOrCreate(customerName)).thenReturn(customer);
        when(orderRepository.create(customer)).thenReturn(order);

        Order createdOrder = orderService.create(customerName);

        assertEquals(order, createdOrder);
        verify(customerService, times(1)).getOrCreate(customerName);
        verify(orderRepository, times(1)).create(customer);
    }

    @Test
    void testAddExistingProductWithSufficientQuantity() throws ProductNotFoundException {
        Order order = new Order(new Customer("John Doe"));
        String productName = "Laptop";
        int count = 5;
        Warehouse warehouse = new Warehouse("Warehouse1", 10);
        Product product = new Product(productName);
        Stock stock = new Stock(product, 1000, count);

        when(warehouseService.findWarehouse(productName, count)).thenReturn(warehouse);
        when(productRepository.getByName(productName)).thenReturn(product);
        when(warehouseService.getStock(warehouse, productName)).thenReturn(stock);
        when(orderRepository.addDelivery(anyInt(), any(Delivery.class))).thenReturn(order);

        Order updatedOrder = orderService.addProduct(order, productName, count, false);

        assertEquals(order, updatedOrder);
        verify(warehouseService, times(1)).findWarehouse(productName, count);
        verify(productRepository, times(1)).getByName(productName);
        verify(warehouseService, times(1)).getStock(warehouse, productName);
        verify(orderRepository, times(1)).addDelivery(anyInt(), any(Delivery.class));
    }

    @Test
    void testAddNonExistentProduct() {
        Order order = new Order(new Customer("John Doe"));
        String productName = "NonExistentProduct";
        int count = 5;

        when(warehouseService.findWarehouse(productName, count)).thenReturn(null);

        assertThrows(ProductNotFoundException.class, () -> {
            orderService.addProduct(order, productName, count, false);
        });

        verify(warehouseService, times(1)).findWarehouse(productName, count);
        verifyNoMoreInteractions(productRepository, orderRepository);
    }

    @Test
    void testAddProductWithInsufficientQuantity() throws ProductNotFoundException {
        Order order = new Order(new Customer("John Doe"));
        String productName = "Laptop";
        int count = 10;

        when(warehouseService.findWarehouse(productName, count)).thenReturn(null);

        assertThrows(ProductNotFoundException.class, () -> {
            orderService.addProduct(order, productName, count, false);
        });

        verify(warehouseService, times(1)).findWarehouse(productName, count);
        verifyNoMoreInteractions(productRepository, orderRepository);
    }
}
