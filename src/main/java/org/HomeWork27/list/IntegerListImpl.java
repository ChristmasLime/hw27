package org.HomeWork27.list;

import org.HomeWork27.exception.ElementNoFoundException;
import org.HomeWork27.exception.InvalidIndexException;
import org.HomeWork27.exception.ItemCannotBeNullException;
import org.HomeWork27.exception.StorageIsFullException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList{
    private final Integer[] elements;
    private int size;

    public IntegerListImpl() {
        elements = new Integer[10];
    }

    public IntegerListImpl(Integer initSize) {
        elements = new Integer[initSize];
    }

    @Override
    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        elements[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            elements[size++] = item;
            return item;
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        elements[index] = item;
        return item;
    }


    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNoFoundException();
        }
        return remove(index, item);
    }

    @Override
    public Integer remove(int index, Integer item) {
        validateIndex(index);
        if (!elements[index].equals(item)) {
            throw new ElementNoFoundException();
        }
        Integer removedItem = elements[index];
        if (index != size - 1) {
            System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        }
        elements[size - 1] = null;
        size--;
        return removedItem;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] storageCopy = toArray();
        sort(storageCopy);
        return binarySearch(storageCopy, item);
    }

    @Override
    public Integer indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return elements[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new ItemCannotBeNullException();
        }
    }

    private void validateSize() {
        if (size == elements.length) {
            throw new StorageIsFullException();
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new InvalidIndexException();
        }
    }

    private void sort(Integer[] arr) {
        for (int i = 1 ;i<arr.length;i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j-1]>=temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private boolean binarySearch(Integer[]arr,Integer item) {
        int min = 0;
        int max = arr.length - 1;

        while (max <= max) {
            int mid = (min + max) / 2;

            if (item ==arr[mid]) {
                return true;
            }
            if (item<arr[mid]) {
                max = mid - 1;
            }else {
                min = mid + 1;
            }
        }
        return false;
    }
}
