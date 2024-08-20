package org.workwork.g_spring.homework_g3.src.test.javaa;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ResultsProcessorTest {

    @Test
    public void testResult() {
        javaa.ResultsProcessor resultsProcessor = new javaa.ResultsProcessor();
        int total = resultsProcessor.calculateTotalPoints("src\\main\\resources\\keyFile.txt", "src\\main\\resources\\studentFile.txt");
        assertEquals(12, total);
        assertNotEquals(18, total);
    }
}
