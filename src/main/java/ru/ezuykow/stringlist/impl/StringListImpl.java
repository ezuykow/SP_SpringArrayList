package ru.ezuykow.stringlist.impl;

import ru.ezuykow.stringlist.StringList;
import ru.ezuykow.stringlist.exceptions.ItemNotExistException;
import ru.ezuykow.stringlist.exceptions.NullStringListException;

import java.util.Arrays;

import static ru.ezuykow.stringlist.impl.StringListUtil.*;

public class StringListImpl implements StringList {

    private String[] items;
    private int arraySize;
    private int itemsCount;

    public StringListImpl() {
        this(DEFAULT_ARRAY_SIZE);
    }

    public StringListImpl(int initialArraySize) {
        items = new String[initialArraySize];
        arraySize = initialArraySize;
    }

    @Override
    public String add(String item) {
        extendArrayIfNeeded();
        checkItemIsNotNull(item);
        items[itemsCount] = item;
        return items[itemsCount++];
    }

    @Override
    public String add(int index, String item) {
        if (index == itemsCount) {
            return add(item);
        }
        checkIndexInValidRange(index, itemsCount);
        checkItemIsNotNull(item);
        extendArrayIfNeeded();
        items = insertItem(item, index, items, itemsCount++);
        return items[index];
    }

    @Override
    public String set(int index, String item) {
        checkIndexInValidRange(index, itemsCount);
        checkItemIsNotNull(item);
        items[index] = item;
        return items[index];
    }

    @Override
    public String remove(int index) {
        checkIndexInValidRange(index, itemsCount);
        String removedItem = items[index];
        if (index == itemsCount - 1) {
            items[index] = null;
        } else {
            items = removeItem(index, items, itemsCount);
        }
        itemsCount--;
        return removedItem;
    }

    @Override
    public String remove(String item) {
        int index = indexOf(item);
        if (index == -1) {
            throw new ItemNotExistException();
        }
        return remove(index);
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < itemsCount; i++) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = itemsCount - 1; i >= 0; i--) {
            if (items[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndexInValidRange(index, itemsCount);
        return items[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new NullStringListException();
        }
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(items, itemsCount);
    }

    @Override
    public int size() {
        return itemsCount;
    }

    @Override
    public boolean isEmpty() {
        return itemsCount == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(items, null);
        itemsCount = 0;
    }

    private void extendArrayIfNeeded() {
        if (itemsCount == arraySize) {
            items = extendArray(items);
        }
    }
}
