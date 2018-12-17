package com.sjh.algorithm.dynamic;

/**
 * @author sjh
 * @date 2018/12/15
 * 计算斐波那契额数列第n项
 */
public class Fib {

    /**
     * 传统计算斐波那契额
     */
    private static int getFib1(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return getFib1(n - 1) + getFib1(n - 2);
    }

    /**
     * 自顶向下备忘录法
     */
    private static int getFib2(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] fibs = new int[n + 1];

        for (int i = 0; i < fibs.length; i++) {
            fibs[i] = -1;
        }

        return getRealFib2(n, fibs);
    }

    private static int getRealFib2(int n, int[] fibs) {
        if (fibs[n] != -1) {
            return fibs[n];
        }
        if (n <= 2) {
            fibs[n] = 1;
        } else {
            fibs[n] = getRealFib2(n - 1, fibs) + getRealFib2(n - 2, fibs);
        }
        return fibs[n];
    }

    /**
     * 自底向上动态规划
     * 先计算子问题再计算父问题
     */
    private static int getFib3(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] fibs = new int[n + 1];
        fibs[0] = 0;
        fibs[1] = 1;

        for (int i = 2; i < fibs.length; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }
        return fibs[n];
    }

    /**
     * 优化版自底向上
     * 节省空间
     */
    private static int getFib4(int n) {
        if (n <= 0) {
            return 0;
        }
        int fib1 = 0;
        int fib2 = 1;
        int fib3 = -1;

        for (int i = 2; i <= n; i++) {
            fib3 = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib3;
        }
        return fib3;
    }


    public static void main(String[] args) {
        final int n = 10;
        System.out.println(getFib1(n));
        System.out.println(getFib2(n));
        System.out.println(getFib3(n));
        System.out.println(getFib4(n));
    }
}
