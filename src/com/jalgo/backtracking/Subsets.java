package com.jalgo.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<ArrayList<Integer>> powerSet(int[] set) {
        List<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
        powerSetCore(set, subsets, new ArrayList<Integer>(), 0);
        return subsets;
    }
    private static void powerSetCore(int[] set, List<ArrayList<Integer>> subsets, ArrayList<Integer> subset, int index) {
        if(index >= set.length) {
            subsets.add(subset);
        } else {
            powerSetCore(set, subsets, cloneList(subset, set[index]), index + 1);
            powerSetCore(set, subsets, cloneList(subset, null), index + 1);
        }
    }
    private static <T> ArrayList<T> cloneList(List<T> list, T newItem) {
        ArrayList<T> result = new ArrayList<T>(list);
        if(newItem != null)
            result.add(newItem);
        return result;
    }
}
