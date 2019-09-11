package com.jalgo.strings;

import com.jalgo.common.ISearchable;
import jdk.dynalink.linker.GuardedInvocationTransformer;

import java.math.BigInteger;
import java.util.*;

import static com.jalgo.common.Strings.createHash;

public class StringSearchRK implements ISearchable {
    public List<Integer> search(String input, String pattern) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        long hashPattern = 0;
        long hashTxt = 0;
        long pow = 1;
        int m = pattern.length();
        for (int i = 0; i < m; i++) {
            hashPattern = nextHash(hashPattern, pattern, i);
            hashTxt = nextHash(hashTxt, input, i);
            if(i >= 1) {
                pow = (pow * radix) % prime;
            }
        }

        if ((hashPattern == hashTxt) && isMatch(input, pattern,0)) {
            result.add(0);
        }
        for (int i = m; i < input.length(); i++) {
            // We should substract leading polynom 'digit' (+prime to exclude negative result)
            hashTxt = nextHash((hashTxt + prime - pow * input.charAt(i - m) % prime) % prime, input, i);
            int offset = i - m + 1;
            if ((hashPattern == hashTxt) && isMatch(input, pattern, offset)) {
                result.add(offset);
            }
        }

        return result;
    }

    private static long prime = BigInteger.probablePrime(31, new Random()).longValue();
    private static long radix = 97;
    private static long nextHash(long prevHash, String text, int index) {
        return (prevHash * radix + text.charAt(index)) % prime;
    }
    private static boolean isMatch(String txt, String pattern, int i) {
        for (int j = 0; j < pattern.length(); j++) {
            if (pattern.charAt(j) != txt.charAt(i + j))
                return false;
        }
        return true;
    }
}