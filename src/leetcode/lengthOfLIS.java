package leetcode;

/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */

import java.util.Arrays;

public class lengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int index = 1;
        int result = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                index++;
            } else {
                if (result <= index) {
                    result = index;
                }
                index = 1;
            }
        }
        return result;
    }

    public int[] lengthOfLIS2(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if (i < 0) i = -(i + 1);
            dp[i] = x;
            if (i == len) len++;
        }
        return dp;
    }

    public int[] lengthOfLIS3(int[] nums) {

    }

    public static void main(String[] args) {
        int[] tmp = {10, 9, 2, 5, 3, 7, 101, 18};
        lengthOfLIS lis = new lengthOfLIS();
//        System.out.println(lis.lengthOfLIS2(tmp));
        for (int val : lis.lengthOfLIS2(tmp)) {
            System.out.println(val);
        }
    }
}
