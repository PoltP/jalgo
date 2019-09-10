package com.jalgo.other.test;

import com.jalgo.common.Utils;
import com.jalgo.other.ReservoirSampling;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class ReservoirSamplingTest {
    @Test
    public void sampleInteger() {
        ReservoirSampling rs = new ReservoirSampling();
        List<Integer> stream = Arrays.asList(new Integer[30]);
        for (int i = 0; i < stream.size(); i++) {
            stream.set(i, i);
        }
        List<Integer> sample = rs.getSample(stream, 4, stream.size());
        sample.forEach(item -> assertTrue(stream.contains(item)));
    }
    @Test
    public void sampleString() {
        ReservoirSampling rs = new ReservoirSampling();
        List<String> stream = Arrays.asList(new String[] { "Pasha", "Sasha", "Masha", "Dasha", "Glasha", "Natasha", "Kesha", "Grisha", "Gosha", "Moysha" });
        List<String> sample = rs.getSample(stream, 3, stream.size());
        sample.forEach(item -> assertTrue(stream.contains(item)));
    }
}
