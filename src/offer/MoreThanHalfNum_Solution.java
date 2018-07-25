package offer;

public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        int num = array[0];
        int flag = 0;
        for (int i = 0; i < array.length; i++) {
            if (num != array[i]) {
                if (flag == 0) {
                    num = array[i];
                } else {
                    flag--;
                }
            } else {
                flag++;
            }
        }
        if (flag == 0) {
            return 0;
        } else {
            return num;
        }
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        MoreThanHalfNum_Solution tmp = new MoreThanHalfNum_Solution();
        System.out.println(tmp.MoreThanHalfNum_Solution(test));
    }
}
