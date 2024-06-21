package org.workwork.c_java_core_one.homework_c4.workshop;

import org.workwork.c_java_core_one.homework_c4.workshop.exceptions.ItemNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class InMemoryStorage implements Storage {

    private static final int INITIAL_CAPACITY = 256;
    private final Map<String, Wheel> items = new HashMap<>(INITIAL_CAPACITY);

    @Override
    public void putItem(Wheel wheel) {
        items.put(wheel.id(), wheel);
    }

    @Override
    public Wheel getItem(String id) {
        Wheel wheel = items.get(id);
        if (wheel == null) {
            throw new ItemNotFoundException(id);
        }
        return wheel;
    }

    @Override
    public boolean containsItem(String id) {
        return items.containsKey(id);
    }

    @Override
    public Wheel removeItem(String id) {
        return null;
    }
}
