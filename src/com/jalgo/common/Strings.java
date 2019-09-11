package com.jalgo.common;

import java.util.function.IntFunction;

public final class Strings {
    public static int[] createZfunction(String str, boolean isReversed) {
        int n = str.length();
        int[] z = new int[n];
        IntFunction<Character> charAt = value -> str.charAt(isReversed ? (n - 1 - value) : value);

        // (left, right) - best block
        for (int i = 1, left = 0, right = 0; i < n; ++i) {
            if (i <= right) {
                z[i] = Math.min(right - i + 1, z[i - left]);
            }
            while (i + z[i] < n && charAt.apply(z[i]) == charAt.apply(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] - 1 > right) {
                right = i + z[i] - 1;
                left = i;
            }
        }

        return z;
    }
}
