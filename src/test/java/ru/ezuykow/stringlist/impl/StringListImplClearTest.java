package ru.ezuykow.stringlist.impl;

import org.junit.jupiter.api.Test;
import ru.ezuykow.stringlist.StringList;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplClearTest {

    @Test
    public void isEmptyShouldReturnTrueAfterClear() {
        StringList out = new StringListImpl();
        out.add("1");
        out.clear();
        assertTrue(out.isEmpty());
    }
}