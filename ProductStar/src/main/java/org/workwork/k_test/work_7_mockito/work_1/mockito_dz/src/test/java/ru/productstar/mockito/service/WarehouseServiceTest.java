package ru.productstar.mockito.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.productstar.mockito.model.Product;
import ru.productstar.mockito.model.Stock;
import ru.productstar.mockito.model.Warehouse;
import ru.productstar.mockito.repository.WarehouseRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WarehouseServiceTest {

    @Mock
    private WarehouseRepository warehouseRepository;

    @InjectMocks
    private WarehouseService warehouseService;

    @Test
    void testFindWarehouseForNonExistentProduct() {
        String productName = "NonExistentProduct";
        int count = 5;

        when(warehouseRepository.all()).thenReturn(Arrays.asList(
                new Warehouse("Warehouse1", 10),
                new Warehouse("Warehouse2", 20)
        ));

        Warehouse result = warehouseService.findWarehouse(productName, count);

        assertNull(result);
        verify(warehouseRepository, times(1)).all();
    }

    @Test
    void testFindWarehouseForExistingProductWithSufficientQuantity() {
        String productName = "Laptop";
        int count = 5;
        Product product = new Product(productName);
        Stock stock = new Stock(product, 1000, 10);
        Warehouse warehouse = new Warehouse("Warehouse1", 10);
        warehouse.addStock(stock);

        when(warehouseRepository.all()).thenReturn(Arrays.asList(
                new Warehouse("Warehouse2", 20),
                warehouse
        ));

        Warehouse result = warehouseService.findWarehouse(productName, count);

        assertEquals(warehouse, result);
        verify(warehouseRepository, times(1)).all();
    }

    @Test
    void testFindWarehouseForExistingProductWithInsufficientQuantity() {
        String productName = "Laptop";
        int count = 15;
        Product product = new Product(productName);
        Stock stock = new Stock(product, 1000, 10);
        Warehouse warehouse = new Warehouse("Warehouse1", 10);
        warehouse.addStock(stock);

        when(warehouseRepository.all()).thenReturn(Arrays.asList(warehouse));

        Warehouse result = warehouseService.findWarehouse(productName, count);

        assertNull(result);
        verify(warehouseRepository, times(1)).all();
    }

    @Test
    void testFindClosestWarehouseForExistingProductWithSufficientQuantity() {
        String productName = "Laptop";
        int count = 5;
        Product product = new Product(productName);
        Stock stock = new Stock(product, 1000, 10);
        Warehouse warehouse1 = new Warehouse("Warehouse1", 10);
        warehouse1.addStock(stock);
        Warehouse warehouse2 = new Warehouse("Warehouse2", 5);
        warehouse2.addStock(stock);
        Warehouse warehouse3 = new Warehouse("Warehouse3", 20);
        warehouse3.addStock(stock);

        when(warehouseRepository.all()).thenReturn(Arrays.asList(warehouse1, warehouse2, warehouse3));

        Warehouse result = warehouseService.findClosestWarehouse(productName, count);

        assertEquals(warehouse2, result);
        verify(warehouseRepository, times(1)).all();
    }

    @Test
    void testFindClosestWarehouseForNonExistentProduct() {
        String productName = "NonExistentProduct";
        int count = 5;

        when(warehouseRepository.all()).thenReturn(Arrays.asList(
                new Warehouse("Warehouse1", 10),
                new Warehouse("Warehouse2", 20)
        ));

        Warehouse result = warehouseService.findClosestWarehouse(productName, count);

        assertNull(result);
        verify(warehouseRepository, times(1)).all();
    }
}
