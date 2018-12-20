package com.sjh.algorithm.dynamic;

/**
 * @author sjh
 * @date 2018/12/14
 * 钢条切割问题是这样的:给定一段长度为n英寸的钢条和一个价格表(求切割钢条方案,使得销售收益R(n)最大)。
 * 注意,如果长度为n英寸的钢条的价格力足够大,最优解可能就是完全不需要切割。
 * 此问题满足最优子结构性质
 * 使用动态规划算法时，用子问题的最优解来构造原问题的最优解。因此必须考查最优解中用到的所有子问题。
 * 在动态规划算法中使用数组来保存子问题的解，这样子问题多次求解的时候可以直接查表不用调用函数递归。
 */
public class SteelBarCut {

    /**
     * 长度和对应价格
     */
    private static final int[] PRICE = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

    /**
     * 递归版本求解最大利润
     */
    private static int getMaxProfit1(int length) {

        if (length <= 0) {
            return 0;
        }

        int maxProfit = -1;

        for (int i = 1; i <= length; i++) {
            maxProfit = Math.max(maxProfit, PRICE[i - 1] + getMaxProfit1(length - i));
        }

        return maxProfit;
    }

    /**
     * 动态规划自顶向下备忘录法求解最大利润
     */
    private static int getMaxProfit2(int length) {
        int[] maxProfitArray = new int[length + 1];

        for (int i = 0; i < maxProfitArray.length; i++) {
            maxProfitArray[i] = -1;
        }

        return cut(maxProfitArray, length);
    }

    private static int cut(int[] maxProfitArray, int n) {
        if (n <= 0) {
            return 0;
        }

        int maxProfit = -1;


        if (maxProfitArray[n] >= 0) {
            return maxProfitArray[n];
        }

        for (int i = 1; i <= n; i++) {
            maxProfit = Math.max(maxProfit, cut(maxProfitArray, n - i) + PRICE[i - 1]);
        }

        maxProfitArray[n] = maxProfit;
        return maxProfit;
    }

    /**
     * 动态规划自底向上求解最大利润
     */
    private static int getMaxProfit3(int length) {
        if (length <= 0) {
            return 0;
        }

        int[] maxProfitArray = new int[length + 1];

        maxProfitArray[0] = 0;

        for (int i = 1; i < maxProfitArray.length; i++) {
            int maxProfit = -1;
            for (int j = 1; j <= i; j++) {
                maxProfit = Math.max(maxProfit, maxProfitArray[i - j] + PRICE[j - 1]);
            }
            maxProfitArray[i] = maxProfit;
        }

        return maxProfitArray[length];
    }

    public static void main(String[] args) {
        int length = 4;
        System.out.println(getMaxProfit1(length));
        System.out.println(getMaxProfit2(length));
        System.out.println(getMaxProfit3(length));
    }
}
