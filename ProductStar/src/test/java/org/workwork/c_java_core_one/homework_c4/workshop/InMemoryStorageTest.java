package org.workwork.c_java_core_one.homework_c4.workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.workwork.c_java_core_one.homework_c4.workshop.exceptions.ItemNotFoundException;

import java.util.UUID;

class InMemoryStorageTest {

    private Storage storage;

    @BeforeEach
    void setUp() {
        storage = new InMemoryStorage();
    }

    @Test
    void putItem() {
        Wheel wheel = new Wheel(UUID.randomUUID().toString(), "hakkapelita", "winter", "A", 10);

        storage.putItem(wheel);

        Wheel actual = storage.getItem(wheel.id());
        Assertions.assertEquals(wheel, actual);
    }

    @Test
    void getItem() {
        Assertions.assertThrows(ItemNotFoundException.class, () -> storage.getItem("123"));
    }

    @Test
    void containsItem() {
        Wheel wheel1 = new Wheel("1", "hakkapelita", "winter", "A", 10);
        Wheel wheel2 = new Wheel("2", "hakkapelita", "winter", "A", 10);
        Wheel wheel3 = new Wheel("3", "hakkapelita", "summer", "A", 10);

        storage.putItem(wheel1);
        storage.putItem(wheel3);

        Assertions.assertTrue(storage.containsItem("1"));
        Assertions.assertTrue(storage.containsItem("3"));
        Assertions.assertFalse(storage.containsItem("2"));
    }

    @Test
    void removeItem() {
    }
}