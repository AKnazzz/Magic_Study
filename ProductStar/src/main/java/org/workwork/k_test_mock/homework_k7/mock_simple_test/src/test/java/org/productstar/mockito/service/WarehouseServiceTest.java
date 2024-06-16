package org.productstar.mockito.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.productstar.mockito.model.Product;
import org.productstar.mockito.model.Stock;
import org.productstar.mockito.model.Warehouse;
import org.productstar.mockito.repository.WarehouseRepository;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WarehouseServiceTest {

    /**
     * Покрыть тестами методы findWarehouse и findClosestWarehouse.
     * Вызывать реальные методы зависимых сервисов и репозиториев нельзя.
     * Поиск должен осуществляться как минимум на трех складах.
     * <p>
     * Должны быть проверены следующие сценарии:
     * - поиск несуществующего товара
     * - поиск существующего товара с достаточным количеством
     * - поиск существующего товара с недостаточным количеством
     * <p>
     * Проверки:
     * - товар находится на нужном складе, учитывается количество и расстояние до него
     * - корректная работа для несуществующего товара
     * - порядок и количество вызовов зависимых сервисов
     */


    @Mock
    private WarehouseRepository warehouseRepository;

    @InjectMocks
    private WarehouseService warehouseService;

    //Тест 1 согласно заданию. Поиск несуществующего товара.
    @Test
    public void findWarehouses_productAbsent() {
        Warehouse warehouse1 = new Warehouse("Warehouse0", 30);
        warehouse1.addStock(new Stock(new Product("notThatProductOne"), 400, 5));
        warehouse1.addStock(new Stock(new Product("notThatProductTwo"), 300, 7));

        Warehouse warehouse2 = new Warehouse("Warehouse0", 20);
        warehouse2.addStock(new Stock(new Product("notThatProductThree"), 400, 5));
        warehouse2.addStock(new Stock(new Product("notThatProductFour"), 300, 7));

        when(warehouseRepository.all()).thenReturn(new ArrayList<>(List.of(warehouse1, warehouse2)));

        Warehouse foundWarehouse = warehouseService.findWarehouse("product", 2);
        verify(warehouseRepository, times(1)).all();
        assertNull(foundWarehouse);
    }

    //Тест 2 согласно заданию. Поиск существующего товара на правильном складе с достаточным количеством.
    @Test
    public void findWarehouses_productExist() {

        Warehouse warehouse1 = new Warehouse("Warehouse0", 30);
        warehouse1.addStock(new Stock(new Product("notThatProductOne"), 400, 5));
        warehouse1.addStock(new Stock(new Product("notThatProductTwo"), 300, 7));

        Warehouse warehouse2 = new Warehouse("Warehouse0", 20);
        warehouse2.addStock(new Stock(new Product("notThatProductThree"), 400, 5));
        warehouse2.addStock(new Stock(new Product("product"), 300, 7));

        when(warehouseRepository.all()).thenReturn(new ArrayList<>(List.of(warehouse1, warehouse2)));

        Warehouse foundWarehouse = warehouseService.findWarehouse("product", 2);
        verify(warehouseRepository, times(1)).all();
        assertNotNull(foundWarehouse);
        assertEquals(warehouse2, foundWarehouse);
    }

    //Тест 3 согласно заданию. Поиск существующего товара на правильном складе с недостаточным количеством.
    @Test
    public void findWarehouses_productExistNotEnough() {
        Warehouse warehouse1 = new Warehouse("Warehouse0", 30);
        warehouse1.addStock(new Stock(new Product("notThatProductOne"), 400, 5));
        warehouse1.addStock(new Stock(new Product("notThatProductTwo"), 300, 7));

        Warehouse warehouse2 = new Warehouse("Warehouse0", 30);
        warehouse2.addStock(new Stock(new Product("notThatProductThree"), 400, 5));
        warehouse2.addStock(new Stock(new Product("product"), 300, 7));

        when(warehouseRepository.all()).thenReturn(new ArrayList<>(List.of(warehouse1, warehouse2)));

        Warehouse foundWarehouse = warehouseService.findWarehouse("product", 200);
        verify(warehouseRepository, times(1)).all();
        assertNull(foundWarehouse);
    }

    //Тест 4 согласно заданию. Поиск существующего товара на ближайшем складе с достаточным количеством.
    @Test
    public void findWarehouses_productExistClosestWarehouse() {
        Warehouse warehouse1 = new Warehouse("Warehouse0", 30);
        warehouse1.addStock(new Stock(new Product("notThatProductOne"), 400, 5));
        warehouse1.addStock(new Stock(new Product("product"), 300, 7));

        Warehouse warehouse2 = new Warehouse("Warehouse0", 10);
        warehouse2.addStock(new Stock(new Product("notThatProductThree"), 400, 5));
        warehouse2.addStock(new Stock(new Product("product"), 300, 7));

        when(warehouseRepository.all()).thenReturn(new ArrayList<>(List.of(warehouse1, warehouse2)));

        Warehouse foundWarehouse = warehouseService.findClosestWarehouse("product", 2);
        verify(warehouseRepository, times(1)).all();
        assertNotNull(foundWarehouse);
        assertEquals(warehouse2, foundWarehouse);
    }
}
