package ru.ezuykow.stringlist.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ezuykow.stringlist.StringList;
import ru.ezuykow.stringlist.exceptions.IndexIsNotValidException;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplGetTest {

    private StringList out;

    @BeforeEach
    void setUp() {
        out = new StringListImpl(3);
        out.add("1");
        out.add("2");
    }

    @Test
    public void shouldReturnItem() {
        String actual = "2";
        String expected = out.get(1);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowIndexIsNotValidException() {
        assertThrows(IndexIsNotValidException.class,
                () -> out.get(10));
    }
}