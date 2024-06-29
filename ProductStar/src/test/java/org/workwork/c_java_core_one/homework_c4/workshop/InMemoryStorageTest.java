package org.workwork.c_java_core_one.homework_c4.workshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.workwork.c_java_core_one.homework_c4.workshop.exceptions.ItemNotFoundException;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

        Wheel actual = storage.getItem(wheel.getId());
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

        assertThrows(ItemNotFoundException.class, () -> storage.removeItem("2"));
    }

    @Test
    void addListOfItems() throws ItemNotFoundException {
        Wheel wheel1 = new Wheel("1", "hakkapelita", "winter", "A", 10);
        Wheel wheel2 = new Wheel("2", "hakkapelita", "winter", "A", 10);
        Wheel wheel3 = new Wheel("3", "hakkapelita", "summer", "A", 10);

        storage.putAllItems(List.of(wheel1, wheel2, wheel3));

        assertTrue(storage.containsItem("1"));
        assertTrue(storage.containsItem("2"));
        assertTrue(storage.containsItem("3"));
    }

    @Test
    void getAlll() {
        Wheel hakka = new Wheel(UUID.randomUUID().toString(), "hakkapelita", "winter", "A", 10);
        Wheel michelin = new Wheel(UUID.randomUUID().toString(), "michelin", "winter", "B", 10);
        Wheel hakkaSummer = new Wheel(UUID.randomUUID().toString(), "hakkapelita", "summer", "A", 10);
        Wheel nordman = new Wheel(UUID.randomUUID().toString(), "nordman", "winter", "A", 10);
        Wheel noname = new Wheel(UUID.randomUUID().toString(), "noname", "winter", "A", 10);

        storage.putAllItems(List.of(hakka, michelin, hakkaSummer, nordman, noname));

        Map<String, Wheel> allItems = storage.getAllItems();

        assertEquals(5, allItems.size());

        allItems.put("1", new Wheel("1", "hakkapelita", "winter", "A", 10));

        assertEquals(5, storage.getAllItems().size());

        //allItems.forEach((id, wheel) -> System.out.println(id + " :: " + wheel));
    }

    @Test
    void getAlllSortedByModel() {
        Wheel hakka = new Wheel("1", "hakkapelita", "winter", "A", 10);
        Wheel michelin = new Wheel("2", "michelin", "winter", "B", 10);
        Wheel hakkaSummer = new Wheel("3", "hakkapelita", "summer", "A", 10);
        Wheel nordman = new Wheel("4", "nordman", "winter", "A", 10);
        Wheel noname = new Wheel("5", "noname", "winter", "A", 10);
        storage.putAllItems(List.of(hakkaSummer, hakka, michelin, noname, nordman));

        Set<String> expectedModels  = new HashSet<>(List.of("hakkapelita", "michelin", "noname"));

        List<Wheel> allItemsSorted = storage.getAllItemsSorted(wheel -> expectedModels.contains(wheel.getModel()));

        List<Wheel> sortOrder = List.of(hakkaSummer, hakka, michelin, noname);

        assertEquals(4, allItemsSorted.size());
        assertEquals(sortOrder, allItemsSorted);

        //allItems.forEach((id, wheel) -> System.out.println(id + " :: " + wheel));
    }


}
