package offer;

public class RectCover {
    public int RectCover(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }
        return RectCover(target - 1) + RectCover(target - 2);

    }

    public int test(int target) {
        int result = 0;
        int index1 = 1;
        int index2 = 2;
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        }
        for (int i = 0; i < target -2; i++) {
            result = index1 + index2;
            index1 = index2;
            index2 = result;
        }
        return result;
    }

    public static void main(String[] args) {
        RectCover tmp = new RectCover();

        System.out.println(tmp.test(10));
    }


}
