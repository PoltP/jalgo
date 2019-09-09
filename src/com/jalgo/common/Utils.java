package com.jalgo.common;

import java.util.Arrays;
import java.util.Comparator;

public final class Utils {
    public static <T> String arrayToString(T[] a) {
        String s = "";
        for (int i = 0; i < a.length; i++) {
            s += a[i] + (i != a.length - 1 ? ", " : "");
        }
        return '[' + s + ']';
    }

    public static <T> void swap(T[] a, int index1, int index2) {
        T tmp = a[index2];
        a[index2] = a[index1];
        a[index1] = tmp;
    }

    private Utils() {}
}