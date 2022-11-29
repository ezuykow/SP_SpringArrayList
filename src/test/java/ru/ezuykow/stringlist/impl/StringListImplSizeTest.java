package ru.ezuykow.stringlist.impl;

import org.junit.jupiter.api.Test;
import ru.ezuykow.stringlist.StringList;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplSizeTest {

    @Test
    public void shouldReturnItemsCount() {
        StringList out = new StringListImpl();
        out.add("1");
        out.add("2");
        out.add("3");

        int actual = 3;
        int expected = out.size();
        assertEquals(expected, actual);
    }
}