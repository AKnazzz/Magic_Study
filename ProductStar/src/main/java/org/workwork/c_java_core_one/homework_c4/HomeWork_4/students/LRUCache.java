package org.workwork.c_java_core_one.homework_c4.HomeWork_4.students;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<KEY, VALUE> extends LinkedHashMap<KEY, VALUE> {
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
