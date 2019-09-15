package com.jalgo.dynamicprogramming.test;

import com.jalgo.dynamicprogramming.BasicConcept;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BasicConceptTest {
    @Test
    public void fibonacci() {
        BasicConcept.Fibonacci fibonacci = new BasicConcept().new Fibonacci();
        assertEquals("Tabulation (Bottom Up)", 144, fibonacci.tabulation((byte)12));
        assertEquals("Memoization (Top Down)", 144, fibonacci.memoization((byte)12));
    }
    @Test
    public void factorial() {
        BasicConcept.Factorial factorial = new BasicConcept().new Factorial();
        assertEquals("Tabulation (Bottom Up)", 479001600, factorial.tabulation((byte)12));
        assertEquals("Memoization (Top Down)", 479001600, factorial.memoization((byte)12));
    }
}
