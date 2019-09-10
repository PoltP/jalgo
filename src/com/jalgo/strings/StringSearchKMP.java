package com.jalgo.strings;

import java.util.ArrayList;
import java.util.List;

public class StringSearchKMP {
    public List<Integer> search(String input, String pattern) {
        int[] lps = prepareLPS(pattern);
        ArrayList<Integer> result = new ArrayList<Integer>();
        int index = 0, p = 0;
        while (index < input.length()) {
            if (pattern.charAt(p) == input.charAt(index)) {
                index++;
                p++;
                if(p == pattern.length()) {
                    result.add(index - p);
                    p = lps[p - 1];
                }
            } else {
                if(p == 0) {
                    index++;
                } else {
                    p = lps[p - 1];
                }
            }
        }
        return result;
    }

    private static int[] prepareLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        lps[0] = 0;// just to explain that 0'th element is always zero
        int j = 0, index = 1;
        while (index < pattern.length()) {
            if(pattern.charAt(index) == pattern.charAt(j)) {
                lps[index] = j + 1;
                j++;
                index++;
            } else {
                if(j == 0) {
                    lps[index] = 0;
                    index++;
                } else {
                    j = lps[j - 1];
                }
            }
        }
        return lps;
    }
}