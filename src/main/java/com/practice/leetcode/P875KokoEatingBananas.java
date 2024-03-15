package com.practice.leetcode;

import java.util.Arrays;

public class P875KokoEatingBananas {

//     https://www.youtube.com/watch?v=BUFHoQIOnAs
//    https://www.youtube.com/watch?v=Rxf93Ey1fpA&list=PLpIkg8OmuX-LkgtrEF7eyyYWJM3m5tVQY&index=12
//    https://leetcode.com/problems/koko-eating-bananas/description/
//    https://leetcode.com/problems/koko-eating-bananas/solutions/4396242/easy-java-code-detailed-explanation/
    public static int minEatingSpeedV1(int[] piles, int h) {
        int l = 1;
        int r = Integer.MIN_VALUE;
        for (int i : piles) {
            r = Math.max(r, i);
        }
        while (l < r) {
            int mid = l + (r - l) / 2; // per hour I can eat mid number of bananas
            if (canEatAllBananas(piles, mid, h)) {
                r = mid;
            } else l = mid + 1;
        }
        return l;
    }

    private static boolean canEatAllBananas(int[] piles, int mid, int h) {
        int actualHours = 0;
        for (int i : piles) {
            actualHours += i / mid;  //hours

            if (actualHours / mid != 0) {
                actualHours++;
            }
        }
        return actualHours <= h;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int l = 1;
        int r = piles[piles.length - 1];
        int res = r; // not initialising it to 0 but to r(max) because this is the max which our
        // answer can be and we have to find the minimum

        // Applying the binary search
        while (l <= r) {
            int k = (l + r) / 2;
            int hours = 0;
            for (int i : piles) {
                // We have to round up, so we will use Math.ceil
                // Ex: Ceil(7.0 / 3.0) = Ceil(2.333) = 3.0 -> 3 in int
                hours += Math.ceil((double) i / k);
            }

            if (hours <= h) { // Meaning Koko ate faster, she could have gone slower
                res = Math.min(res, k);
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] piles = new int[]{3, 6, 7, 11};
        int h = 8;
        int speed = minEatingSpeed(piles, h);
        System.out.println(speed);
/////////////////////////////////////////////////////////////
        int[] piles1 = new int[]{3, 6, 7, 11};
        int h1 = 8;
        int speed1 = minEatingSpeedV1(piles1, h1);
        System.out.println(speed1);
    }
}
