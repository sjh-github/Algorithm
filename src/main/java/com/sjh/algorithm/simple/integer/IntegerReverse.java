package com.sjh.algorithm.simple.integer;

/**
 * @author sjh
 * @date 2018/12/19
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class IntegerReverse {

    private int reverse1(int x) {
        int afterReverseNum = 0;
        if (x < 0) {
            afterReverseNum = -afterReverseNum;
        }

        while (x != 0) {
            int num = x % 10;
             x /= 10;
            if (afterReverseNum > Integer.MAX_VALUE / 10 || (afterReverseNum == Integer.MAX_VALUE / 10 && num > 7)) {
                afterReverseNum = 0;
                break;
            }
            if (afterReverseNum < Integer.MIN_VALUE / 10 || (afterReverseNum == Integer.MIN_VALUE / 10 && num < -8)) {
                afterReverseNum = 0;
                break;
            }
            afterReverseNum = afterReverseNum * 10 + num;
        }

        return afterReverseNum;
    }

    public static void main(String[] args) {
        IntegerReverse integerReverse = new IntegerReverse();
        System.out.println(integerReverse.reverse1(123));
        System.out.println(integerReverse.reverse1(-123));
        System.out.println(integerReverse.reverse1(120));
        System.out.println(integerReverse.reverse1(-2147483648));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE / 10);
    }
}
