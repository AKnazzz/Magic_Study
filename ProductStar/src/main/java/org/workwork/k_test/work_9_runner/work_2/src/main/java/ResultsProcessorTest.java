package org.workwork.k_test.work_9_runner.work_2.src.main.java;


import org.testng.annotations.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class ResultsProcessorTest {

    @Test
    public void testGetTopRunners() {
        ResultsProcessor resultsProcessor = new ResultsProcessor();
        resultsProcessor.loadResults("C:\\Users\\Admin\\IdeaProjects\\Results\\src\\main\\resources\\results.csv");

        List<Result> topRunners = resultsProcessor.getTopRunners(10, "M", 3);

        resultsProcessor.printRunners(topRunners);

        assertEquals(3, topRunners.size());
        assertEquals("Иван Иванов", topRunners.get(0).getName());
        assertEquals("Петр Петров", topRunners.get(1).getName());
        assertEquals("Сергей Сергеев", topRunners.get(2).getName());
    }
}
