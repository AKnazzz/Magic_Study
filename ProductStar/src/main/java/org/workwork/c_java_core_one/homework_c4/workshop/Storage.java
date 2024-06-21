package org.workwork.c_java_core_one.homework_c4.workshop;


import org.workwork.c_java_core_one.homework_c4.workshop.exceptions.ItemNotFoundException;

//- Добавление товара на склад (идентификатор, название, количество, категория, место хранения)
//    - Добавление списком
//- Удаление товара со склада
//- Поиск товара по идентификатору
//  - Поиск по одному
//  - Поиск всех названия по списку отсортированный в алфавитном порядке
//- Вывод всех товаров на складе
//- Создание отчета по остаткам товаров на складе
//    - Вывод всех категорий товаров
//    - Вывод количества товаров по категории и месту хранения
//    - Вывод общего количества товаров на складе
public interface Storage {
    void putItem(Wheel wheel);
    Wheel getItem(String id) throws ItemNotFoundException;

    boolean containsItem(String id);

    Wheel removeItem(String id);

}
