package org.workwork.c_java_core_one.homework_c4.workshop;

import java.util.HashSet;
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
    public Integer getAggregationByCategoryAndPlace(String category, String place) {
        return null;
    }

    @Override
    public Integer getTotalCount() {
        return null;
    }
}
