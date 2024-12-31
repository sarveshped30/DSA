package org.example.dsa;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

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
        /*int[] arr = new int[]{1, 2, 3, 4, 5};
        recursionQuestions.reverse(arr);
        System.out.println(Arrays.toString(arr));*/

        //Check Palindrome recursively
        /*int[] arr = new int[]{2, 1, 4, 3, 2};
        int[] arr2 = new int[]{2, 3, 4, 3, 2};
        int[] arr3 = new int[]{2, 1, 1, 2};
        System.out.println(recursionQuestions.palindromeCheck(arr3));*/


        //Print subSequences
        /*int[] arr = new int[]{1, 2, 3};
        System.out.println(recursionQuestions.subsets(arr));*/

        //Generate binary Strings
        //recursionQuestions.generateBinaryStringOfLength(3);

        //Print all subSequence of string
        int count = recursionQuestions.printAllSubSequenceOfString("gfg");
        System.out.println();
        System.out.println(count);
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

    public boolean palindromeCheck(int[] arr) {
        return recursivePalindromeCheck(arr, 0, arr.length - 1);
    }

    public boolean recursivePalindromeCheck(int[] arr, int index, int length) {
        if(index > length) return true;

        int element = arr[index];
        if(recursivePalindromeCheck(arr, index + 1, length)) {
            return element == arr[length - index];
        } else {
            return false;
        }
    }

    private final List<List<Integer>> seqList = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        recurse(nums, 0, new ArrayList<>());
        return seqList;
    }

    private void recurse(int[] nums, int index, List<Integer> subSet) {
        if(index == nums.length) {
            seqList.add(new ArrayList<>(subSet));
            return;
        }

        //take
        subSet.add(nums[index]);
        recurse(nums, index + 1, subSet);

        //Don't take
        subSet.removeLast();
        recurse(nums, index + 1, subSet);
    }

    public void generateBinaryStringOfLength(int n) {

        if(n <= 0) return;

        char[] result = new char[n];
        result[0] = '0';
        generateBinaryString(result, 1, n);

        result[0] = '1';
        generateBinaryString(result, 1, n);
    }

    private void generateBinaryString(char[] result, int index, int length) {
        if(index == length) {
            System.out.print(String.valueOf(result) + " ");
            return;
        }

        if(result[index - 1] == '0') {
            result[index] = '0';    // Take zero / don't take one
            generateBinaryString(result, index + 1, length);
            result[index] = '1';    //Take one / don't take zero
            generateBinaryString(result, index + 1, length);
        }

        //As we should not allow consecutive one's
        if(result[index - 1] == '1') {
            result[index] = '0';
            generateBinaryString(result, index + 1, length);
        }
    }

    public int printAllSubSequenceOfString(String str) {
        int len = str.length();
        List<Character> result = new ArrayList<>();
        int index = 0;
        return generateSubSequence(result, index, len, str);
    }

    private int generateSubSequence(List<Character> result, int index, int length, String str) {
        if(index == length) {
            if(result.isEmpty()) {
                return 0;
            } else {
                System.out.print(result.stream().map(String::valueOf).collect(Collectors.joining()) + " ");
                return 1;
            }
        }

        result.add(str.charAt(index));
        int left = generateSubSequence(result, index + 1, length, str);

        result.removeLast();
        int right = generateSubSequence(result, index + 1, length, str);

        return left + right;
    }


}
