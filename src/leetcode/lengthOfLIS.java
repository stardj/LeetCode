package leetcode;

/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

Input: [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */

import java.util.Arrays;
import java.util.TreeMap;

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
            int i = Arrays.binarySearch(dp, 0, len, x);// check whether the x in the dp
            if (i < 0) i = -(i + 1);
            dp[i] = x;
            if (i == len) len++;
        }
        return dp;
    }

    public int lengthOfLIS3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 1;
        int prev1, prev2, count;   // always keep prev1 <= prev2
        for (int i = 0; i < nums.length; i++) {
            prev1 = nums[i];
            prev2 = prev1;
            count = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (prev2 > nums[j] && nums[j] > prev1) {
                    prev2 = nums[j];
                } else if (prev2 < nums[j]) {
                    count++;
                    prev1 = prev2;
                    prev2 = nums[j];
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public int lengthOfLIS4(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();
        int index = 0;
        int flag = -1;
        int result = 0;
        for (int x : nums) {
            treeMap.put(x, index++);
        }
        for (int y : treeMap.values()) {
            if (flag < y) {
                flag = y;
                result++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] tmp = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] tmp1 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        lengthOfLIS lis = new lengthOfLIS();
//        lis.lengthOfLIS4(tmp);
        System.out.println(lis.lengthOfLIS4(tmp1));
//        for (int val : lis.lengthOfLIS2(tmp)) {
//            System.out.println(val);
//        }
    }
}
