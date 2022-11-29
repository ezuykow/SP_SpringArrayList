package ru.ezuykow.stringlist.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ezuykow.stringlist.StringList;
import ru.ezuykow.stringlist.exceptions.NullStringListException;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplEqualsTest {

    private StringList out;
    private StringList otherList;

    @BeforeEach
    public void setUp() {
        out = new StringListImpl(3);
        out.add("1");
        out.add("2");
        out.add("3");

        otherList = new StringListImpl();
        otherList.add("1");
        otherList.add("2");
        otherList.add("3");
    }

    @Test
    public void shouldReturnTrue() {
        assertTrue(out.equals(otherList));
    }

    @Test
    public void shouldReturnFalse() {
        otherList.add("4");
        assertFalse(out.equals(otherList));
    }

    @Test
    public void shouldThrowNullStringListException() {
        assertThrows(NullStringListException.class,
                () -> out.equals(null));
    }
}