package com.practice.leetcode;

import java.util.HashMap;

public class P3LongestSubstring {

//    public static int longestSubstring(String s) {
//        int maxLength = 0;
//        for (int right = 0, left = 0; right < s.length(); right++) {
//            int indexOfFirstOccuranceOfSubstring = s.indexOf(s.charAt(right), left);
//            if (indexOfFirstOccuranceOfSubstring != right) {
//                left = indexOfFirstOccuranceOfSubstring + 1;
//            }
//            maxLength = Math.max(maxLength, right - left + 1);
//        }
//        return maxLength;
//    }

    //Aliter
    public static int longestSubstring(String s) {
        int maxLength = 0;
        HashMap<Character, Integer> visitedCharacters = new HashMap();
        for (int right = 0, left = 0; right < s.length(); right++) {
            char currentCharacter = s.charAt(right);
            if (visitedCharacters.containsKey(currentCharacter) && visitedCharacters.get(currentCharacter) >= left) {
                left = visitedCharacters.get(currentCharacter) + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            visitedCharacters.put(currentCharacter, right);
        }
        return maxLength;
    }

    public static void main(String[] args) {
//        https://www.youtube.com/watch?v=GS9TyovoU4c
        String s = "abcabcbb";
        int longestSubstring = longestSubstring(s);
        System.out.println(longestSubstring);

    }
}
