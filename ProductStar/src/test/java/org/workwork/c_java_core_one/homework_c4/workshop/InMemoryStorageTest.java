package org.workwork.c_java_core_one.homework_c4.workshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.workwork.c_java_core_one.homework_c4.workshop.exceptions.ItemNotFoundException;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InMemoryStorageTest {

    private Storage storage;

    @BeforeEach
    void setUp() {
        storage = new InMemoryStorage();
    }

    @Test
    void putAndGetItem() throws ItemNotFoundException {
        Wheel wheel = new Wheel(UUID.randomUUID().toString(), "hakkapelita", "winter", "A", 10);

        storage.putItem(wheel);

        Wheel actual = storage.getItem(wheel.id());
        assertEquals(wheel, actual);
    }

    @Test
    void getItem() {
        assertThrows(ItemNotFoundException.class, () -> storage.getItem("123"));
    }

    @Test
    void containsItem() {
        Wheel wheel1 = new Wheel("1", "hakkapelita", "winter", "A", 10);
        Wheel wheel2 = new Wheel("2", "hakkapelita", "winter", "A", 10);
        Wheel wheel3 = new Wheel("3", "hakkapelita", "summer", "A", 10);

        storage.putItem(wheel1);
        storage.putItem(wheel3);

        assertTrue(storage.containsItem("1"));
        assertTrue(storage.containsItem("3"));
        assertFalse(storage.containsItem("2"));
    }

    @Test
    void removeItem() throws ItemNotFoundException {
        Wheel wheel1 = new Wheel("1", "hakkapelita", "winter", "A", 10);
        Wheel wheel3 = new Wheel("3", "hakkapelita", "summer", "A", 10);
        storage.putItem(wheel1);
        storage.putItem(wheel3);

        Wheel removeItem = storage.removeItem("1");

        assertTrue(storage.containsItem("3"));
        assertFalse(storage.containsItem("1"));
        assertEquals(removeItem, wheel1);

        assertThrows(ItemNotFoundException.class,  ()  -> storage.removeItem("2"));
    }

    @Test
    void addListOfItems() throws ItemNotFoundException  {
        Wheel wheel1 = new Wheel("1", "hakkapelita", "winter", "A", 10);
        Wheel wheel2 = new Wheel("2", "hakkapelita", "winter", "A", 10);
        Wheel wheel3 = new Wheel("3", "hakkapelita", "summer", "A", 10);

        storage.putAllItem(List.of(wheel1, wheel2, wheel3));

        assertTrue(storage.containsItem("1"));
        assertTrue(storage.containsItem("2"));
        assertTrue(storage.containsItem("3"));
    }
}