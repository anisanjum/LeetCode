package com.practice.leetcode;

import java.util.HashMap;


//        Input:nums=[2,7,11,15], target=9
//        Output:[0,1]
//        Explanation:Because nums[0]+nums[1]==9,we return[0,1].

//        Example 2:
//        Input: nums = [3,2,4], target = 6
//        Output: [1,2]

//        Example 3:
//        Input: nums = [3,3], target = 6
//        Output: [0,1]

public class Twosum {
    public static void main(String[] args) {
        int[] arr = {11, 3, 7, 9, 14, 2};
        int target = 17;
        int[] ans = optimizedTwoSum(arr, target);
        System.out.println(ans[0]+" "+ans[1]);

        ///////////////////////////////////////////
//        int[] twoSum = findTwoSum_BruteForce(arr, target);
//
//        if (twoSum.length == 2) {
//            System.out.println(twoSum[0] + " " + twoSum[1]);
//        } else {
//            System.out.println("No solution found!");
//        }

    }

    private static int[] optimizedTwoSum(int[] arr, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        int secondNumber;
        for (int i = 0; i < arr.length; i++) {
            secondNumber = target - arr[i];
            if (hm.containsKey(secondNumber)) {
                ans[0] = hm.get(secondNumber);
                ans[1] = i;
                break;
            }
            hm.put(arr[i], i);
        }
        return ans;
    }

    private static int[] findTwoSum_BruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

}
