package com.jalgo.common;

import java.util.Comparator;

public interface ISortable<T> {
    void sort(T[] a, Comparator<T> c);
}
