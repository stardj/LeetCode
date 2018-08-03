public class Solution {


    public static void iQickSort(int[] n, int left, int right) {
        int dp;//标兵在全序列的位置，即子序列分割点
        if (left < right) {
            dp = partition(n, left, right);
            iQickSort(n, left, dp - 1);//左边子序列递归快排
            iQickSort(n, dp + 1, right);//右边子序列递归快排
        }
    }

    private static int partition(int[] n, int left, int right) {
        int pivot = n[left];//标兵
        while (left < right) {

            while (left < right && n[right] >= pivot) {
                right--;
            }//找出标兵右边比标兵小的元素
            if (left < right)
                n[left++] = n[right];//交换
            while (left < right && n[left] <= pivot) {
                left++;
            }//找出标兵左边比标兵大的元素
            if (left < right)
                n[right--] = n[left];//交换
        }
        n[left] = pivot;
        return left;//返回标兵最终的位置
    }


    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 4, 5, 4, 3, 2, 1, 11, 22, 33, 21, 12, 321, 41414, 5345};
        iQickSort(testArray, 0, testArray.length - 1);
        for (int arr : testArray) {
            System.out.println(arr);
        }
    }

}
