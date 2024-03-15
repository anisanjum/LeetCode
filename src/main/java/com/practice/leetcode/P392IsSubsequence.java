package com.practice.leetcode;

public class P392IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        int j = 0;
        int k = s.length();
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(j) == t.charAt(i))
                j++;
            if (j == k)
                break;
        }
        return j == k;
    }

    public static void main(String[] args) {
        boolean subsequence = isSubsequence("abc", "ahbgdc");
        System.out.println(subsequence);
    }
}
