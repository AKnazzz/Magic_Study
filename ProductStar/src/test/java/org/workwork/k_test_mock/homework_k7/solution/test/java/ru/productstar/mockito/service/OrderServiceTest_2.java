package org.workwork.k_test_mock.homework_k7.solution.test.java.ru.productstar.mockito.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.ProductNotFoundException;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.model.Customer;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.model.Delivery;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.model.Order;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.model.Warehouse;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.repository.CustomerRepository;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.repository.OrderRepository;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.repository.ProductRepository;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.repository.WarehouseRepository;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.service.CustomerService;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.service.OrderService;
import org.workwork.k_test_mock.homework_k7.solution.main.java.ru.productstar.mockito.service.WarehouseService;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest_2 {


    /**
     * Покрыть тестами методы create и addProduct.
     * Можно использовать вызовы реальных методов.
     * <p>
     * Должны быть проверены следующие сценарии:
     * - создание ордера для существующего и нового клиента +
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

    private CustomerService customerServiceSpy;
    private WarehouseService warehouseServiceSpy;
    private OrderRepository orderRepositorySpy;
    private ProductRepository productRepositorySpy;
    private OrderService orderService;

    @BeforeEach
    public void init() {
        customerServiceSpy = spy(new CustomerService(new CustomerRepository()));
        productRepositorySpy = spy(new ProductRepository());
        warehouseServiceSpy = spy(new WarehouseService(new WarehouseRepository(productRepositorySpy)));
        orderRepositorySpy = spy(new OrderRepository());
        orderService = spy(new OrderService(customerServiceSpy, warehouseServiceSpy, orderRepositorySpy, productRepositorySpy));
    }

    //Тест 1 согласно заданию. Создание ордера для существующего клиента Ivan.
    @Test
    public void create_test_existCustomer() {
        // Создается объект ArgumentCaptor, который используется для захвата аргументов, переданных в методы при их вызове.
        // В данном случае мы захватываем объект типа Customer.
        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);

        Order ivanOrder = orderService.create("Ivan");

        assertNotNull(ivanOrder);
        // Создается объект InOrder, который используется для проверки порядка вызовов методов
        // между мок-объектами customerServiceSpy и orderRepositorySpy.
        InOrder inOrder = inOrder(customerServiceSpy, orderRepositorySpy);
        inOrder.verify(customerServiceSpy, times(1)).getOrCreate("Ivan");
        inOrder.verify(orderRepositorySpy, times(1)).create(customerArgumentCaptor.capture());
        assertEquals(customerArgumentCaptor.getValue(), ivanOrder.getCustomer());
    }

    //Тест 2 согласно заданию. Создание ордера для несуществующего клиента Oleg.
    @Test
    public void create_test_absentCustomer() {
        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);

        Order olegOrder = orderService.create("Oleg");

        assertNotNull(olegOrder);
        InOrder inOrder = inOrder(customerServiceSpy, orderRepositorySpy);
        inOrder.verify(customerServiceSpy, times(1)).getOrCreate("Oleg");
        inOrder.verify(orderRepositorySpy, times(1)).create(customerArgumentCaptor.capture());
        assertEquals(customerArgumentCaptor.getValue(), olegOrder.getCustomer());
    }
    //получение существующего и нового клиентов проверяется в CustomerService

    //Тест 3 согласно заданию. Добавление существующего товара. В достаточном количестве. Обычная доставка
    @Test
    public void addProduct_test_existProductUsualDelivery() throws ProductNotFoundException {
        Order ivanOrder = orderService.create("Ivan");

        Order phone = orderService.addProduct(ivanOrder, "phone", 1, false);
        assertNotNull(phone);
        InOrder inOrder = inOrder(warehouseServiceSpy, productRepositorySpy, warehouseServiceSpy, orderRepositorySpy);
        inOrder.verify(warehouseServiceSpy, times(1)).findWarehouse("phone", 1);
        inOrder.verify(productRepositorySpy, times(1)).getByName("phone");
        inOrder.verify(warehouseServiceSpy, times(1)).getStock(any(Warehouse.class), eq("phone"));
        inOrder.verify(orderRepositorySpy, times(1)).addDelivery(eq(ivanOrder.getId()), any(Delivery.class));
        assertEquals(400, phone.getDeliveries().get(0).getPrice());
    }

    //Тест 4 согласно заданию. Добавление существующего товара. В достаточном количестве. Обычная доставка
    @Test
    public void addProduct_test_existProductFastDelivery() throws ProductNotFoundException {
        Order ivanOrder = orderService.create("Ivan");

        Order phone = orderService.addProduct(ivanOrder, "phone", 1, true);
        assertNotNull(phone);
        InOrder inOrder = inOrder(warehouseServiceSpy, productRepositorySpy, warehouseServiceSpy, orderRepositorySpy);
        inOrder.verify(warehouseServiceSpy, times(1)).findClosestWarehouse("phone", 1);
        inOrder.verify(productRepositorySpy, times(1)).getByName("phone");
        inOrder.verify(warehouseServiceSpy, times(1)).getStock(any(Warehouse.class), eq("phone"));
        inOrder.verify(orderRepositorySpy, times(1)).addDelivery(eq(ivanOrder.getId()), any(Delivery.class));
        assertEquals(450, phone.getDeliveries().get(0).getPrice());
    }

    //Тест 4 согласно заданию. Добавление несуществующего товара.
    @Test
    public void addProduct_test_absentProduct() throws ProductNotFoundException {
        Order ivanOrder = orderService.create("Ivan");

        assertThrows(ProductNotFoundException.class, () -> orderService.addProduct(ivanOrder, "someProduct", 1, false));
    }

    //Тест 5 согласно заданию. Добавление существующего товара. В недостаточном количестве
    @Test
    public void addProduct_test_existProductNotEnough() throws ProductNotFoundException {
        Order ivanOrder = orderService.create("Ivan");

        assertThrows(ProductNotFoundException.class, () -> orderService.addProduct(ivanOrder, "someProduct", 100, false));
    }

}
