package tasks.turnstile;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class TurnstileTest {
    @Test
    public void simple1() {
        Turnstile turnstile = new Turnstile();
        List<Integer> list = turnstile.getTimes(Arrays.asList(new Integer[]{0, 0, 1, 5}), Arrays.asList(new Integer[]{0, 1, 1, 0}));
        assertArrayEquals(new Integer[]{2, 0, 1, 5}, list.toArray());
    }

    @Test
    public void simple2() {
        Turnstile turnstile = new Turnstile();
        List<Integer> list = turnstile.getTimes(Arrays.asList(new Integer[]{0, 1, 1, 3, 3}), Arrays.asList(new Integer[]{0, 1, 0, 0, 1}));
        assertArrayEquals(new Integer[]{0, 2, 1, 4, 3}, list.toArray());
    }
}
