package org.workwork.c_java_core_one.homework_c4.workshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class BasicAnalyticsTest {
    private Analytics analytics;
    private Storage storage;

    @BeforeEach
    public void setUp() {
        storage = new InMemoryStorage();
        analytics = new BasicAnalytics(storage);

    }


    @Test
    void getCategories() {
        Wheel wheel = new Wheel("1", "hakkapelita", "summer", "A", 5);
        Wheel winter = new Wheel("2", "hakkapelita", "winter", "A", 5);
        Wheel winter2 = new Wheel("22", "hakkapelita", "winter", "A", 5);
        Wheel winter3 = new Wheel("23", "hakkapelita", "winter", "A", 5);
        Wheel allSeasons = new Wheel("3", "hakkapelita", "allSeasons", "A", 5);

        storage.putAllItems(List.of(wheel, winter, winter2, winter3, allSeasons));

        Set<String> categories = analytics.getCategories();

        Assertions.assertEquals(3, categories.size());
        Assertions.assertTrue(categories.contains("summer"));
        Assertions.assertTrue(categories.contains("winter"));
        Assertions.assertTrue(categories.contains("allSeasons"));
    }

    @Test
    void getAggregationByCategoryAndPlace() {
    }

    @Test
    void getTotalCount() {
    }
}