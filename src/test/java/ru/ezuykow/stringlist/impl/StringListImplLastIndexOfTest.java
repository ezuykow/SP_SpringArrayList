package ru.ezuykow.stringlist.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ezuykow.stringlist.StringList;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplLastIndexOfTest {

    private StringList out;

    @BeforeEach
    void setUp() {
        out = new StringListImpl();

        out.add("1");
        out.add("2");
        out.add("1");
        out.add("3");
    }

    @Test // indexOf(item)
    public void shouldReturnIndexOfItem() {
        int actual = 2;
        int expected = out.lastIndexOf("1");
        assertEquals(expected, actual);
    }

    @Test // indexOf(item) when this item not consists
    public void shouldReturnBadIndex() {
        int actual = -1;
        int expected = out.lastIndexOf("10");
        assertEquals(expected, actual);
    }
}