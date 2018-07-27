package leetcode;

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

    public static void main(String[] args) {
        int[] tmp = {10, 9, 2, 5, 3, 7, 101, 18};
        lengthOfLIS lis = new lengthOfLIS();
        System.out.println(lis.lengthOfLIS(tmp));
    }
}
