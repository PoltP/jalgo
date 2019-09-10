package com.jalgo.strings.test;

import com.jalgo.strings.StringSearchKMP;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertArrayEquals;

public class StringSearchKMPTest {
    @Test
    public void searchEmptyLPS() {
        String test = "ZABCAXABAABABCCABCAXAAABBCCABCAXABC";
        StringSearchKMP kmp = new StringSearchKMP();
        List<Integer> indices = kmp.search(test, "ABC");
        assertArrayEquals(new Integer[]{ 1, 11, 15, 27, 32 }, indices.toArray());
    }
    @Test
    public void searchLPS1() {
        String test = "ZABCAXABAABABCCABCAXAAABBCCABCAXABC";
        StringSearchKMP kmp = new StringSearchKMP();
        List<Integer> indices = kmp.search(test, "ABCAXAB");
        assertArrayEquals(new Integer[]{ 1, 27 }, indices.toArray());
    }
    @Test
    public void searchLPS2() {
        String test = "ABCABCXAZABCABCXABAABABCABCCABCAXAAABBCCABCABCXABABCABC";
        StringSearchKMP kmp = new StringSearchKMP();
        List<Integer> indices = kmp.search(test, "ABCABCXAB");
        assertArrayEquals(new Integer[]{ 9, 40 }, indices.toArray());
    }
}
