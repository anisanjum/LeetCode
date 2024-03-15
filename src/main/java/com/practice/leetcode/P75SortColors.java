package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//https://medium.com/nerd-for-tech/75-sort-colors-15768309bf2f
//https://leetcode.com/problems/sort-colors/description/
//https://walkccc.me/LeetCode/problems/75/
public class P75SortColors {

    // Count Sort TC: O(N) , SC: O(N)
    public ArrayList<Integer> sortColors(int[] nums) {
        int[] c = new int[3];
        for (int i : nums) {
            c[i]++;
        }
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j < c[i]; j++) {
                ans.add(i);
            }
        }
        return ans;
    }

    // Not exactly 2 pointer but kind of 2 pointer
    public ArrayList<Integer> sortColorsV1(int[] A) {
        int n = A.length;
        int zero = 0;
        int two = n - 1;
//        int i = 0;
        for (int i = 0; i < two;) {
//        while (i <= two) {
            if (A[i] == 0) {
                swap(A, i, zero);
                zero++;
                i++;
            }
            else if (A[i] == 2) {
                swap(A, i, two);
                two--;
            } else i++;
        }
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(Arrays.stream(A).boxed().toArray(Integer[]::new)));
        return result;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        P75SortColors p75SortColors = new P75SortColors();
        int[] A = new int[]{2, 0, 2, 1, 1, 0};

//        ArrayList<Integer> colors = p75SortColors.sortColors(A);
//        System.out.print("Count Sort: ");
//        System.out.println(colors);

        ArrayList<Integer> colorsV1 = p75SortColors.sortColorsV1(A);
        System.out.println(colorsV1);
    }

}
