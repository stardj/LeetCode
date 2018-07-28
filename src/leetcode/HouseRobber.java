package leetcode;
/*
Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber {

    public int rob(int[] nums) {

        int[] V = new int[nums.length];
        int result = 0;
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        V[0] = nums[0];
        V[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            V[i] = Math.max(V[i - 1], nums[i] + V[i - 2]);
            if (V[i] > result) {
                result = V[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] tmp = {1, 2, 3, 1};
        int[] tmp1 = {2,7,9,3,1};
        int[] tmp2 = {2,1,1,2};
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(tmp2));
    }

}
