package ru.ezuykow.stringlist.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ezuykow.stringlist.StringList;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplToArrayTest {

    @Test
    void shouldReturnStringsArray() {
        StringList out = new StringListImpl();
        out.add("1");
        out.add("2");
        out.add("3");

        String[] actual = new String[]{"1", "2", "3"};
        String[] expected = out.toArray();

        assertArrayEquals(expected, actual);
    }
}