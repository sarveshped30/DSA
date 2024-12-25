package org.example.dsa;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

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

    //Pow using recursion
    public double pow(double x, int n) {
        if(n == Integer.MIN_VALUE) {
            return 1 / (x * pow(x, -(n + 1)));      // X multiplication for sign (+ or -)
        }

        if(n == 0) return 1.0;
        if(n == 1) return x;

        if(n < 0) {
            return 1 / pow(x, -n);
        }

        double half = pow(x, n/2);

        return n % 2 == 0 ? half * half : half * half * x;
    }

    public static void main(String[] args) {
        RecursionQuestions recursionQuestions = new RecursionQuestions();
        //System.out.println(recursionQuestions.pow(2.00000d, -2));

        //Backtracking
        //System.out.println(recursionQuestions.generateParenthesis(3));

        //Reverse Array using recursion
        int[] arr = new int[]{1, 2, 3, 4, 5};
        recursionQuestions.reverse(arr);
        System.out.println(Arrays.toString(arr));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(result, "", 0, 0, n);
        return result;
    }

    private void backtracking(List<String> result, String str, int open, int close, int noOfParenthesis) {
        if(str.length() == noOfParenthesis * 2) {
            result.add(str);
            return;
        }

        if(open < noOfParenthesis) {
            backtracking(result, str + "(", open + 1, close, noOfParenthesis);
        }

        if(close < open) {
            backtracking(result, str + ")", open, close + 1, noOfParenthesis);
        }
    }

    public void reverse(int[] arr) {
        reverseArray(arr, 0, arr.length-1);
    }

    public void reverseArray(int[] arr, int index, int length) {
        if (index > length) return;

        int element = arr[index];
        reverseArray(arr, index+1, length);
        arr[length - index] = element;
    }
}
