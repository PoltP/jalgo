package com.jalgo.datastructures.test;

import com.jalgo.datastructures.Heap;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeapTest {
    static Integer[] test = new Integer[]{30, -70, 90, 10, -5, 80, 60, -100, 60};

    @Test
    public void min() {
        Heap heap = new Heap(test, (a, b) -> Integer.compare(a, b));
        assertEquals("Min", -100, heap.peek());
    }

    @Test
    public void max() {
        Heap heap = new Heap(test, (a, b) -> Integer.compare(b, a));
        assertEquals("Max", 90, heap.peek());
    }
}
