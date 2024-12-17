package org.example.dsa;

public class RecursionQuestions {

    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();
        boolean positive = true;
        int val = 0;

        while(i < n && s.charAt(i) == ' ') {
            i++;
        }

        if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            positive = s.charAt(i) == '+';
            i++;
        }

        val = convertAtoi(val, i, n, s, positive);


        return positive ? val : -val;
    }

    public int convertAtoi(int val, int i, int n, String s, boolean positive) {
        if (i < n && ('0' <= s.charAt(i) && s.charAt(i) <= '9')) {
            int currentDigit = s.charAt(i) - '0';

            // Positive Overflow Check
            if (positive && val > (Integer.MAX_VALUE - currentDigit) / 10) {
                return Integer.MAX_VALUE;
            }

            // Negative Overflow Check
            if (!positive && val > (Integer.MAX_VALUE - currentDigit) / 10) {
                return Integer.MIN_VALUE;
            }

            // Accumulate the digit
            val = val * 10 + currentDigit;

            // Recurse to the next character
            return convertAtoi(val, i + 1, n, s, positive);
        }

        // Apply the sign when recursion ends
        return val;
    }
}
