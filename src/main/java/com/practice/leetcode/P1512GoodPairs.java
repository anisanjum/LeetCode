package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class P1512GoodPairs {
    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int result = 0;

        for (int num : nums) {
            if (count.containsKey(num)) {
                result += count.get(num);
                count.put(num, count.get(num) + 1);
            } else {
                count.put(num, 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        int[] A = new int[]{3, 2, 2, 3, 1};
        int[] A = new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3};
        int numIdenticalPairs = numIdenticalPairs(A);
        System.out.println(numIdenticalPairs);
    }
}
