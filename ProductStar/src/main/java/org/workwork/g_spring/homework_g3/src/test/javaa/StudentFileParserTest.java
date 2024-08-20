package org.workwork.g_spring.homework_g3.src.test.javaa;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class StudentFileParserTest {

    @Test
    public void testParseFile() {
        javaa.StudentFileParser studentFileParser = new javaa.StudentFileParser();
        List<String> studentAnswers = studentFileParser.parseFile("src\\main\\resources\\studentFile.txt");

        assertNotEquals(9, studentAnswers.size());
        assertEquals(10, studentAnswers.size());
        assertNotEquals(11, studentAnswers.size());
    }
}