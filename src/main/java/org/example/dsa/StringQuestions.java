package org.example.dsa;

import java.util.Map;
import java.util.HashMap;

public class StringQuestions {

    public static void main(String[] args) {

        // Is Palindrome ignore special characters
        /*String s = "Was it a car or a cat I saw?";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindromeWithoutRegex(s));*/

        String word = "a good    example";
        System.out.println(reverseWords(word));
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
}
