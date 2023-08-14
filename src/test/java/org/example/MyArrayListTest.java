package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private MyArrayList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    void add() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    void insert() {
        list.insert(2,10);
        list.insert(1, 20);
        list.insert(0,30);
        assertEquals(3, list.size());
        assertEquals(30, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(10, list.get(3));
    }

    @Test
    void get() {
        list.add(10);
        assertEquals(10, list.get(0));
    }

    @Test
    void remove() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.remove(1);
        assertEquals(2, list.size());
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1));
    }

    @Test
    void removeAll() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.removeAll();
        assertEquals(0, list.size());
    }

    @Test
    void indexOf() {
        list.add(10);
        list.add(20);
        list.add(30);
        assertEquals(1, list.indexOf(20));
    }

    @Test
    void sort() {
        list.add(40);
        list.add(20);
        list.add(10);
        list.add(30);
        list.sort(Integer::compareTo);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
        assertEquals(40, list.get(3));
    }
}