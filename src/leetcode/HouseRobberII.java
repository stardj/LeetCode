package leetcode;
/*
Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobberII {

    public int rob(int[] nums) {

        int[] V1 = new int[nums.length];
        int[] V2 = new int[nums.length];
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        V1[0] = nums[0];
        V1[1] = Math.max(nums[0], nums[1]);
        int result1 = Math.max(V1[0], V1[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            V1[i] = Math.max(V1[i - 1], nums[i] + V1[i - 2]);
            if (V1[i] > result1) {
                result1 = V1[i];
            }
        }

        V2[1] = nums[1];
        V2[2] = Math.max(nums[1], nums[2]);
        int result2 = Math.max(V2[1], V2[2]);
        for (int i = 3; i < nums.length; i++) {
            V2[i] = Math.max(V2[i - 1], nums[i] + V2[i - 2]);
            if (V2[i] > result2) {
                result2 = V2[i];
            }
        }

        return Math.max(result1, result2);
    }

    public static void main(String[] args) {
        int[] tmp = {2, 3, 2};
        int[] tmp1 = {1, 2, 3, 1};
        HouseRobberII houseRobber = new HouseRobberII();
        System.out.println(houseRobber.rob(tmp1));
    }
}
