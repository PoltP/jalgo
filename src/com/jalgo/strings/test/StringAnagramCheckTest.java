package com.jalgo.strings.test;

import com.jalgo.strings.StringAnagramChecker;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringAnagramCheckTest {
    @Test
    public void anagram() {
        assertTrue(StringAnagramChecker.xor("ELVIS", "LIVES"));
        assertTrue(StringAnagramChecker.xor("аз есмь строка живу я мерой остр", "за семь морей ростка я вижу рост"));
    }
    @Test
    public void notanagram() {
        assertFalse(StringAnagramChecker.xor("ELVIS", "LEAVE"));
    }
}
