package org.let.internship;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {

    private Task1 task1 = new Task1();

    @Test
    public void oneWord() {
        assertThat(task1.capitalize("vladimir"))
                .isEqualTo("Vladimir");
    }

    @Test
    public void twoWords() {
        assertThat(task1.capitalize("vladimir igorevich"))
                .isEqualTo("Vladimir Igorevich");
    }

    @Test
    public void bigLetters() {
        assertThat(task1.capitalize("VLADIMIR IGOREVICH"))
                .isEqualTo("Vladimir Igorevich");
    }

}