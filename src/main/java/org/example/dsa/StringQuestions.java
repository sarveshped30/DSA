package org.example.dsa;

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
}
