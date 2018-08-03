public class WaterMelon {

    //训练集中的下一步是涨的概率
    public static double getUpRate(int[] input) {
        int upCount = 0;
        int downCount = 0;
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] - input[i + 1] >= 0) {
                upCount++;
            } else {
                downCount++;
            }
        }
        return upCount / (upCount + downCount);
    }

    //训练集中下一步的涨跌的平均值
    public static double getUpMean(int[] input) {
        int upCount = 0;
        int downCount = 0;
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] - input[i + 1] >= 0) {
                upCount += input[i + 1] - input[i];
            } else {
                downCount += input[i + 1] - input[i];
            }
        }
        return (upCount + downCount) / input.length;
    }

    //得到涨跌的期望
    public static double getUpE(int[] input) {
        return getUpMean(input) * getUpRate(input);
    }

    public static int[] getArr(int[] input, int len) {
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            tmp[i] = input[i];
        }
        return tmp;
    }

    public static int getWatermelon(int[] input) {
        for (int i = 0; i < input.length / 2; i++) {
            if (getUpE(getArr(input, i + input.length / 2)) <= 0) {
                return input[i];
            }
        }
        return input[input.length - 1];
    }


    public static void main(String[] args) {
        int[] testSet = new int[100];
        for (int i = 0; i < 100; i++) {
            testSet[i] = (int) (Math.random() * 100);
        }
        getWatermelon(testSet);
    }

}
