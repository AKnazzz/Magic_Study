package org.workwork.c_java_core_one.homework_c4.workshop;

import java.util.Set;

/*
- [ ] Создание отчета по остаткам товаров на складе
    - [ ] Вывод всех категорий товаров
    - [ ] Вывод количества товаров по категории и месту хранения
    - [ ] Вывод общего количества товаров на складе

 */

public interface Analytics {
    Set<String> getCategories();
    Integer getAggregationByCategoryAndPlace(String category, String place);
    Integer getTotalCount();
}
