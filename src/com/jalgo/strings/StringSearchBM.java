package com.jalgo.strings;

import com.jalgo.common.ISearchable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StringSearchBM implements ISearchable {
    public List<Integer> search(String input, String pattern) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<Character, Integer> stops = prepareStopTable(pattern);
        int[] shifts = prepareSuffixShifts(pattern);
        int m = pattern.length(), j;

        // Galil improvement for standard Boyer-Moore algorithm
        int i = 0, bound = 0;
        while (i <= input.length() - m) {
            for (j = m - 1; (j >= bound) && (pattern.charAt(j) == input.charAt(i + j)); j--);
            if (j < bound) {
                result.add(i);
                bound = m - shifts[0];
                j = -1;
            } else {
                bound = 0;
            }
            i += (j < bound) ? shifts[j+1] : Math.max(shifts[j+1], j - stops.getOrDefault(input.charAt(i + j), -1));
        }

//      // Standard Boyer-Moore
//      for (int i = 0, j = 0; i <= input.length() - m; i += suffixShifts[j+1]) {
//          for (j = m - 1; j >= 0 && pattern.charAt(j) == input.charAt(i + j); j--);
//          if (j < 0) {
//              result.add(i);
//          }
//      }

        return result;
    }

    private static HashMap<Character, Integer> prepareStopTable(String str) {
        HashMap<Character, Integer> stopTable = new HashMap<Character, Integer>(str.length());
        for (int i = 0; i < str.length(); i++) {
            stopTable.put(str.charAt(i), i);
        }
        return stopTable;
    }

    private static int[] prepareSuffixShifts(String str) {
        int[] z = com.jalgo.common.Strings.createZfunction(str, true);
        int m = str.length();
        int[] suffixShifts = new int[m + 1];
        Arrays.fill(suffixShifts, m);
        for (int i = m - 1; i > 0; i--) {
            suffixShifts[m - z[i]] = i;
        }
        for (int i = 1, r = 0; i <= m - 1; i++) {
            if (i + z[i] == m) {
                for (; r <= i; r++) {
                    if (suffixShifts[r] == m)
                        suffixShifts[r] = i;
                }
            }
        }

        return suffixShifts;
    }
}