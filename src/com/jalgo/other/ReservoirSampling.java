package com.jalgo.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReservoirSampling<T> {
    public List<T> getSample(List<T> input, int k, int n) {
        Random rnd = new Random();
        List<T> reservoir = new ArrayList<T>();
        int index = 0;
        for (; index < k; index++) {
            reservoir.add(input.get(index));
        }
        for (; index < n; index++) {
            int j = rnd.nextInt(index + 1);// [0, i+i) => [0, i]
            if(j < k)
                reservoir.set(j, input.get(index));
        }
        return reservoir;
    }
}
