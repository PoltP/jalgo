package com.jalgo.dynamicprogramming;

public class BasicConcept {
    public class Factorial {
        private long[] dpMemo = new long[Byte.MAX_VALUE + 1];

        public long tabulation(byte number) {// Bottom Up
            long[] dpTab = new long[number + 1];
            dpTab[0] = 1;
            for (int i = 1; i <= number; i++) {
                dpTab[i] = dpTab[i - 1] * i;
            }
            return dpTab[number];
        }

        public long memoization(byte number) {// Top Down
            if (number == 0) return 1;
            if(this.dpMemo[number] != 0) return this.dpMemo[number];
            return this.dpMemo[number] = number * this.memoization((byte)(number - 1));
        }
    }

    public class Fibonacci {
        private long[] dpMemo = new long[Byte.MAX_VALUE + 1];

        public long tabulation(byte number) {// Bottom Up
            long[] dpTab = new long[number + 1];
            dpTab[0] = 0;
            dpTab[1] = 1;
            dpTab[2] = 1;
            for (int i = 3; i <= number; i++) {
                dpTab[i] = dpTab[i - 1] + dpTab[i - 2];
            }
            return dpTab[number];
        }

        public long memoization(byte number) {// Top Down
            if (number == 0) return 0;
            if (number == 1 || number == 2) return 1;
            if(this.dpMemo[number] != 0) return this.dpMemo[number];
            return this.dpMemo[number] = this.memoization((byte)(number - 1)) + this.memoization((byte)(number - 2));
        }
    }
}
