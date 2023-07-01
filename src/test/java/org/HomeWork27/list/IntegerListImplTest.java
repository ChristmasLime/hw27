package org.HomeWork27.list;

import org.HomeWork27.IntegerListImpl;
import org.HomeWork27.exception.ElementNoFoundException;
import org.HomeWork27.exception.InvalidIndexException;
import org.HomeWork27.exception.ItemCannotBeNullException;
import org.HomeWork27.exception.StorageIsFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerListImplTest {

    private IntegerListImpl list;

    @BeforeEach
    public void setUp() {
        list = new IntegerListImpl();
    }

    @Test
    void addTest() {
        list.add(5);
        assertEquals(5, list.get(0));
        assertEquals(1, list.size());
        assertTrue(list.contains(5));
    }

    @Test
    void addForIndexTest() {
        list.add(1);
        list.add(2);
        list.add(0, 5);
        assertEquals(5, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    void removeTest() {
        list.add(5);
        list.remove((Integer) 5);
        assertTrue(list.isEmpty());
    }

    @Test
    void removeForIndexTest() {
        list.add(100);
        list.add(200);
        list.remove(0);
        assertEquals(200, list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    void setTest() {
        list.add(9);
        list.add(8);
        list.set(1, 10);
        assertEquals(10,list.get(1));
    }
    @Test
    void indexOfTest() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(0, list.indexOf(1));
        assertEquals(1, list.indexOf(2));
        assertEquals(2, list.lastIndexOf(3));
        assertEquals(-1, list.indexOf(4));
    }

    @Test
    void equalsTest() {
        IntegerListImpl otherList = new IntegerListImpl();
        list.add(4);
        otherList.add(4);
        assertTrue(list.equals(otherList));
    }

    @Test
    void clearTest() {
        list.add(9);
        list.add(8);
        list.clear();
        assertTrue(list.isEmpty());
    }
    @Test
    void add_StorageIsFullExceptionTest() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        assertThrows(StorageIsFullException.class, () ->
                list.add(11));
    }

    @Test
    void add_InvalidIndexExceptionTest() {
        assertThrows(InvalidIndexException.class, () ->
                list.add(-1, 5));
    }

    @Test
    void add_ItemCannotBeNullException() {
        assertThrows(ItemCannotBeNullException.class, () ->
                list.add(null));
    }

    @Test
    void set_NullItemExceptionTest() {
        list.add(10);
        assertThrows(ItemCannotBeNullException.class, () ->
                list.set(0, null));
    }

    @Test
    void remove_ElementNoFoundExceptionTest() {
        assertThrows(ElementNoFoundException.class, () ->
                list.remove((Integer) 5));
    }

}

