package ru.ezuykow.stringlist.impl;

import ru.ezuykow.stringlist.exceptions.IndexIsNotValidException;
import ru.ezuykow.stringlist.exceptions.ItemIsNullException;

import java.util.Arrays;

public class StringListUtil {

    public final static int DEFAULT_ARRAY_SIZE = 10;
    public final static int EXTENSION_FACTOR = 2;

    public static String[] extendArray(String[] array) {
        final int oldSize = array.length;
        final int newSize = oldSize * EXTENSION_FACTOR;
        return array = Arrays.copyOf(array, newSize);
    }

    public static void checkItemIsNotNull(String item) {
        if (item == null) {
            throw new ItemIsNullException();
        }
    }

    public static void checkIndexInValidRange(int index, int itemsCount) {
        final int lastIndex = itemsCount - 1;
        if (index < 0 || index > lastIndex) {
            throw new IndexIsNotValidException();
        }
    }

    public static String[] insertItem(String item, int index, String[] items, int itemsCount) {
        String[] newArray = new String[items.length];
        System.arraycopy(items, 0, newArray, 0, index);
        newArray[index] = item;
        System.arraycopy(items, index, newArray, index + 1, itemsCount - index);
        return newArray;
    }

    public static String[] removeItem(int index, String[] items, int itemsCount) {
        String[] newArray = new String[items.length];
        System.arraycopy(items, 0, newArray, 0, index);
        System.arraycopy(items, index + 1, newArray, index, itemsCount - index - 1);
        return newArray;
    }
}
