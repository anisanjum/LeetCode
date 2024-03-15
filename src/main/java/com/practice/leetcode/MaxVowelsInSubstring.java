package com.practice.leetcode;

public class MaxVowelsInSubstring {
    public int maxVowels(String s, int k) {
        int max = 0;
        int c = 0;
//        Loop1
        for (int i = 0; i < k; i++) {
            if (isvowel(s.charAt(i)))
                c++;
        }
        max = c;
        // Loop2
        for (int i = k; i < s.length(); i++) {
            if (isvowel(s.charAt(i))) {
                c++;
            }
            if (isvowel(s.charAt(i - k))) {
                c--;
            }
            max = Math.max(max, c);
        }
        return max;
    }

    public boolean isvowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        String A = "abciiidef";
        MaxVowelsInSubstring mv = new MaxVowelsInSubstring();
        int maxVowels = mv.maxVowels(A, 3);
        System.out.println(maxVowels);

    }
}