package com.jalgo;

import com.jalgo.common.Utils;
import com.jalgo.sorting.BubbleSort;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        BubbleSort<Integer> bubbleSort = new BubbleSort<Integer>();
        Integer[] arr = new Integer[]{ 30, 70, 90, 10, 80, 60 };
        bubbleSort.sort(arr, (a, b) -> Integer.compare(a, b));

        System.out.println("Test: " + Utils.arrayToString(arr));
    }
}
