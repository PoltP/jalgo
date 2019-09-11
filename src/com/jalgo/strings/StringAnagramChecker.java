package com.jalgo.strings;

public class StringAnagramChecker {
    public static boolean xor(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        int xor = 0;
        for (int i = 0; i < str1.length(); i++) {
            xor = xor ^ str1.charAt(i) ^ str2.charAt(i);
        }
        return xor == 0;
    }
}
