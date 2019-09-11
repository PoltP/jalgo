package com.jalgo.strings.test;

import com.jalgo.common.ISearchable;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public abstract class BaseStringSearchTest {
    protected abstract ISearchable createSearchable();

    @Test
    public void searchEmptyLPS() {
        ISearchable searchable = this.createSearchable();
        String test = "ZABCAXABAABABCCABCAXAAABBCCABCAXABC";
        List<Integer> indices = searchable.search(test, "ABC");
        assertArrayEquals(new Integer[]{ 1, 11, 15, 27, 32 }, indices.toArray());
    }
    @Test
    public void searchLPS1() {
        ISearchable searchable = this.createSearchable();
        String test = "ZABCAXABAABABCCABCAXAAABBCCABCAXABC";
        List<Integer> indices = searchable.search(test, "ABCAXAB");
        assertArrayEquals(new Integer[]{ 1, 27 }, indices.toArray());
    }
    @Test
    public void searchLPS2() {
        ISearchable searchable = this.createSearchable();
        String test = "ABCABCXAZABCABCXABAABABCABCCABCAXAAABBCCABCABCXABABCABC";
        List<Integer> indices = searchable.search(test, "ABCABCXAB");
        assertArrayEquals(new Integer[]{ 9, 40 }, indices.toArray());
    }
    @Test
    public void searchText() {
        ISearchable searchable = this.createSearchable();
        String test = "Peter Piper picked a peck of pickled peppers.\n" +
                "A peck of pickled peppers Peter Piper picked.\n" +
                "If Peter Piper picked a peck of pickled peppers,\n" +
                "Where's the peck of pickled peppers Peter Piper picked?";
        List<Integer> indices = searchable.search(test, "pick");
        assertArrayEquals(new Integer[]{ 12, 29, 56, 84, 107, 124, 161, 189 }, indices.toArray());
        indices = searchable.search(test, "Peter Piper");
        assertArrayEquals(new Integer[]{ 0, 72, 95, 177 }, indices.toArray());
    }
}