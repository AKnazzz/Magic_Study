package org.workwork.c_java_core_one.homework_c4.workshop;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CachedAnalytics implements Analytics {

    private final Map<CategoryAndPlace, Integer> cache = new LRUCache<>(2);
    private final BasicAnalytics basicAnalytics;

    public CachedAnalytics(BasicAnalytics basicAnalytics) {
        this.basicAnalytics = basicAnalytics;
    }

    @Override
    public Set<String> getCategories() {
        return basicAnalytics.getCategories();
    }

    @Override
    public Map<CategoryAndPlace, Integer> getAggregationByCategoryAndPlace() {
        return basicAnalytics.getAggregationByCategoryAndPlace();
    }

    @Override
    public Integer getAggregationByCategoryAndPlace(CategoryAndPlace categoryAndPlace) {
        Integer integer = cache.get(categoryAndPlace);
        if (integer == null) {
            integer = basicAnalytics.getAggregationByCategoryAndPlace(categoryAndPlace);
            cache.put(categoryAndPlace, integer);
        }
        return integer;
    }

    @Override
    public Integer getTotalCount() {
        return basicAnalytics.getTotalCount();
    }
}

class LRUCache<KEY, VALUE> extends LinkedHashMap<KEY, VALUE> {

    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<KEY, VALUE> eldest) {
        return size() > capacity;
    }
}
