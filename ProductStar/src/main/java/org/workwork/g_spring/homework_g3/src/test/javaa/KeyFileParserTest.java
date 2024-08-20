package org.workwork.g_spring.homework_g3.src.test.javaa;



import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class KeyFileParserTest {

    @Test
    public void testParseFile() {
        javaa.KeyFileParser keyFileParser = new javaa.KeyFileParser();
        List<String> keyAnswers = keyFileParser.parseFile("src\\main\\resources\\keyFile.txt");

        assertNotEquals(9, keyAnswers.size());
        assertEquals(10, keyAnswers.size());
        assertNotEquals(11, keyAnswers.size());
    }
}
