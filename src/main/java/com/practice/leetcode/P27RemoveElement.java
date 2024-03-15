package com.practice.leetcode;

import java.util.Arrays;

public class P27RemoveElement {

    public static void main(String[] args) {
        int[] A = new int[]{3, 2, 2, 3};
        int element = removeElement(A, 3);
        System.out.println(element);
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
//        int[] arr = new int[n];
//        Arrays.sort(nums);
        for (int j = 0; j < n; j++) {
            if (nums[j] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        return i;
    }
}