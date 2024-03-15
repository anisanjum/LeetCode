package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuffixSumArrayBruteForce {

    public static void main(String[] args) {
//        List<Integer> arr = List.of(10, 14, 16, 20);
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(10, 14, 16, 20));

        int n = arr.size();

        // Initialize the suffix sum array with all elements as 0
        List<Integer> suffixSum = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            suffixSum.add(0);
        }

        for (int i = 0; i < n; i++) {
            // Calculate the sum of remaining elements to the right
            for (int j = i; j < n; j++) {
                suffixSum.set(i, suffixSum.get(i) + arr.get(j));
            }
        }

        // Printing the computed suffix sum array
        System.out.print("Suffix sum array: ");
        for (int i = 0; i < suffixSum.size(); i++) {
            System.out.print(suffixSum.get(i) + " ");
        }
    }
}
