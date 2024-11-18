package org.example.dsa;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;

public class StringQuestions {

    public static void main(String[] args) {

        // Is Palindrome ignore special characters
        /*String s = "Was it a car or a cat I saw?";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindromeWithoutRegex(s));*/

        /*String word = "a good    example";
        System.out.println(reverseWords(word));*/

        /*String word = "raaeaedere";
        System.out.println(frequencySort(word));*/

        /*String atoi = "+-12";
        System.out.println(myAtoi(atoi))*/

        //Count subStrings
        String s = "abc";
        String e = "pqpqs";
        System.out.println(countExactKSubString(e, 2));

    }

    public static boolean isPalindromeWithoutRegex(String s) {
        int n = s.length();
        if (n == 1) return true;

        int i = 0;
        int j = n - 1;

        while (i < j) {
            boolean isISpecial = !Character.isLetterOrDigit(s.charAt(i));
            boolean isJSpecial = !Character.isLetterOrDigit(s.charAt(j));
            boolean skip =  false;
            if(isISpecial && isJSpecial) {
                i++;
                j--;
                skip = true;
            } else if (isISpecial) {
                i++;
                skip = true;
            } else if (isJSpecial) {
                j--;
                skip = true;
            }

            if(skip) continue;

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }


    public static String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        String[] words = s.split(" ");

        for(int i = words.length - 1; i >= 0; i--) {
            if(words[i] == "") continue;

            ans.append(words[i]);

            if(i > 0) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }

    public static String longestCommonPrefix(String[] strs) {
        //Edge case
        if(strs.length == 1) return strs[0];

        String prefix = strs[0];
        int minIndex = prefix.length() - 1;
        int index = -1;

        for(String str : strs) {
            int l1 = 0;
            int l2 = 0;

            while(l1 < prefix.length() && l2 < str.length()) {
                if(prefix.charAt(l1) == str.charAt(l2)) {
                    l1++;
                    l2++;
                    index++;
                } else {
                    break;
                }
            }

            if(index == -1) {
                return "";
            } else {
                minIndex = Math.min(index, minIndex);
                if(minIndex < prefix.length()) {    //End index should be less than length
                    prefix = prefix.substring(0, minIndex + 1);
                }
                index = -1;
            }
        }

        return prefix;
    }

    //Time Complexity = O(N)
    //Space complexity = O(N)
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> maps = new HashMap<>();
        Map<Character, Character> mapt = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char schar = s.charAt(i);
            char tchar = t.charAt(i);

            if(maps.containsKey(schar)) {
                if(maps.get(schar) != tchar) {
                    return false;
                }
                continue;
            } else {
                maps.put(schar, tchar);
            }

            if(mapt.containsKey(tchar)) {
                if(mapt.get(tchar) != schar) {
                    return false;
                }
            } else {
                mapt.put(tchar, schar);
            }

        }

        return true;
    }

    //Optimal isoMorphic solution
    //Time complexity = O(N)
    //Space complexity = O(1)
    public static boolean isIsomorphicOptimal(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }

        //256 to cover all ASCII characters
        int[] maps = new int[256];
        int[] mapt = new int[256];

        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(maps[c1] != mapt[c2]) {
                return false;
            }

            maps[c1] = maps[c1]++;
            mapt[c2] = mapt[c2]++;
        }

        return true;
    }

    public static String frequencySort(String s) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Use a max-heap to sort characters by frequency
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(frequencyMap.entrySet());

        // Step 3: Build the result
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char c = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; i++) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int index = 0, sign = 1, total = 0;
        int n = s.length();

        // Step 1: Ignore leading whitespaces
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // Step 2: Handle signs
        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // Step 3: Convert digits to integer
        while (index < n) {
            char currentChar = s.charAt(index);
            if (!Character.isDigit(currentChar)) {
                break; // Stop at the first non-digit character
            }

            int digit = currentChar - '0';

            // Step 4: Handle overflow
            if (total > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            index++;
        }

        return total * sign;
    }


    //Sliding window algorithm to count subString  ## lengthCount(sub strings with incremental lefts and exact same right)
    public static int countSubstrings(String s) {
        int count = 0;
        int start = 0, end = s.length() - 1;
        for(; start <= end; start++) {
            count += (end - start) + 1;
        }

        return count;
    }


    //At MOST
    public static int countAtMostKSubStrings(String s, int k) {
        int count = 0, start = 0, end = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(; end < s.length(); end++) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while(map.size() > k) {
                char lChar = s.charAt(start);
                int lCount = map.get(lChar) - 1;
                map.put(lChar, lCount);
                if(lCount == 0) {
                    map.remove(lChar);
                }
                start++;
            }

            count += end - start + 1;
        }

        return count;
    }

    //Exact
    public static int countExactKSubString(String s, int k) {
        return countAtMostKSubStrings(s, k) - countAtMostKSubStrings(s, k - 1);
    }

    //At least
    public static int countAtLeastKSubString(String s, int k) {
        return countAtMostKSubStrings(s, s.length()) - countAtMostKSubStrings(s, k - 1);
    }

}
