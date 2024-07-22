package org.workwork.c_java_core_one.homework_c4.workshop;

import org.workwork.c_java_core_one.homework_c4.workshop.exceptions.ItemNotFoundException;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InMemoryStorage implements Storage {

    private static final int INITIAL_CAPACITY = 256;
    private final Map<String, Wheel> items = new HashMap<>(INITIAL_CAPACITY);

    @Override
    public void putItem(Wheel wheel) {
        items.put(wheel.getId(), wheel);
    }

    @Override
    public Wheel getItem(String id) throws ItemNotFoundException {
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
    public Wheel removeItem(String id) throws ItemNotFoundException {
        Wheel remove = items.remove(id);
        if (remove == null) {
            throw new ItemNotFoundException(id);
        }
        return remove;
    }

    @Override
    public void putAllItems(List<Wheel> items) {
        for (Wheel item : items) {
            putItem(item);
        }
    }

    @Override
    public Map<String, Wheel> getAllItems() {
        return new HashMap<>(items);
    }

    @Override
    public List<Wheel> getAllItemsSorted(Predicate<Wheel> predicate) {
        return items.values().stream().filter(predicate)
                .sorted(Comparator.comparing(Wheel::getModel)
                        .thenComparing(Wheel::getCategory)
                        .thenComparing(Wheel::getPlace)
                        .thenComparing(Wheel::getId))
                .collect(Collectors.toList());
    }
}
