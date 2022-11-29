package ru.ezuykow.stringlist.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ezuykow.stringlist.StringList;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplIsEmptyTest {

    private StringList out;

    @BeforeEach
    public void setUp() {
        out = new StringListImpl();
    }

    @Test
    public void shouldReturnTrue() {
        assertTrue(out.isEmpty());
    }

    @Test
    public void shouldReturnFalse() {
        out.add("1");
        assertFalse(out.isEmpty());
    }

}