package ru.ezuykow.stringlist.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ezuykow.stringlist.StringList;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplContainsTest {

    private StringList out;

    @BeforeEach
    public void setUp() {
        out = new StringListImpl();
        out.add("1");
    }


    @Test
    public void shouldReturnTrueWhenItemContains() {
        assertTrue(out.contains("1"));
    }

    @Test
    public void shouldReturnFalseThenItemNotContains() {
        assertFalse(out.contains("10"));
    }
}