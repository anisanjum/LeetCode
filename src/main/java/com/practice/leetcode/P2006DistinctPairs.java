package com.practice.leetcode;

public class P2006DistinctPairs {

    public static int countKDifference(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] - nums[j] == k || nums[j] - nums[i] == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 2, 1, 5, 4};
        int countKDifference = countKDifference(A, 2);
        System.out.println(countKDifference);
    }
}
