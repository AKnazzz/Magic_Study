package org.workwork.g_spring.homework_g3.work_1.src.test.java;

import org.workwork.g_spring.homework_g3.work_1.src.main.java.KeyFileParser;

import java.util.List;



public class KeyFileParserTest {

    @Test
    public void testParseFile() {
        KeyFileParser keyFileParser = new KeyFileParser();
        List<String> keyAnswers = keyFileParser.parseFile("src\\main\\resources\\keyFile.txt");

        assertNotEquals(9, keyAnswers.size());
        assertEquals(10, keyAnswers.size());
        assertNotEquals(11, keyAnswers.size());
    }
}
