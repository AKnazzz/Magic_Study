package org.workwork.c_java_core_one.homework_c4.workshop;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BasicAnalytics implements Analytics {

    private final Storage storage;

    public BasicAnalytics(Storage storage) {
        this.storage = storage;
    }

    @Override
    public Set<String> getCategories() {
        Set<String> categories = new HashSet<>();
        for (Wheel wheel : storage.getAllItems().values()) {
            categories.add(wheel.getCategory());
        }
        return categories;
//        return storage.getAllItems().values().stream().map(item -> item.getCategory()).collect(Collectors.toSet());
    }


    @Override
    public Map<CategoryAndPlace, Integer> getAggregationByCategoryAndPlace() {

        Map<CategoryAndPlace, Integer> aggregations = new HashMap<>();
        Map<String, Wheel> storageItems = storage.getAllItems();
        for (Wheel wheel : storageItems.values()) {
            CategoryAndPlace categoryAndPlace = new CategoryAndPlace(wheel.getCategory(), wheel.getPlace());
            Integer aggregation = aggregations.getOrDefault(categoryAndPlace, 0);
            aggregation += wheel.getQuantity();
            aggregations.put(categoryAndPlace, aggregation);
        }

        return aggregations;
    }

    @Override
    public Integer getAggregationByCategoryAndPlace(CategoryAndPlace categoryAndPlace) {
        Integer quantity = 0;
        Map<String, Wheel> storageItems = storage.getAllItems();
        for (Wheel wheel : storageItems.values()) {
            if (wheel.getCategory().equals(categoryAndPlace.category()) && wheel.getPlace().equals(categoryAndPlace.place())) {
                quantity += wheel.getQuantity();
            }
        }
        return quantity;
    }

    @Override
    public Integer getTotalCount() {
        return storage.getAllItems().values().stream().map(Wheel::getQuantity).mapToInt(Integer::intValue).sum();
    }
}
