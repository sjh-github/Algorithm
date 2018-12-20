package com.sjh.algorithm.simple.integer;

import java.util.Stack;

/**
 * @author sjh
 * @date 2018/12/19
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class IsPalindrome {

    private boolean isPalindrome1(int x) {
        boolean isPalindrome = true;

        char[] xArray = String.valueOf(x).toCharArray();
        int start = 0;
        int end = xArray.length - 1;
        while (start < end) {
            if (xArray[start] != xArray[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }
        return isPalindrome;
    }

    private boolean isPalindrome2(int x) {
        boolean isPalindrome = true;
        if (x < 0 || ((x % 10) == 0 && x / 10 > 0)) {
            isPalindrome = false;
        } else if (x / 10 != 0){
                Stack<Integer> stack = new Stack<Integer>();
                int xCopy = x;
                while (xCopy > 0) {
                    stack.add(xCopy % 10);
                    xCopy = xCopy / 10;
                }

                int size = 0;
                while (size < stack.size() + 1) {
                    size++;
                    if (stack.pop() != (x % 10)) {
                        isPalindrome = false;
                        break;
                    }
                    x = x / 10;
                }

        }
        return isPalindrome;
    }

    private boolean isPalindrome3(int x) {
        boolean isPalindrome = true;
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            isPalindrome = false;
        } else {
            int reverseNum = 0;
            while (x > reverseNum) {
                reverseNum = reverseNum * 10 + x % 10;
                x /= 10;
            }
            return x == reverseNum || x == reverseNum / 10;
        }
        return isPalindrome;
    }

    public boolean isPalindrome4(int x) {
        boolean isPalindrome = true;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(x)).reverse();
        isPalindrome = String.valueOf(x).equals(stringBuilder.toString());
        return isPalindrome;
    }


    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        System.out.println(isPalindrome.isPalindrome1(121));
        System.out.println(isPalindrome.isPalindrome1(-121));
        System.out.println(isPalindrome.isPalindrome1(10));
        System.out.println(isPalindrome.isPalindrome1(0));

        System.out.println(isPalindrome.isPalindrome2(121));
        System.out.println(isPalindrome.isPalindrome2(-121));
        System.out.println(isPalindrome.isPalindrome2(10));
        System.out.println(isPalindrome.isPalindrome2(0));

        System.out.println(isPalindrome.isPalindrome3(121));
        System.out.println(isPalindrome.isPalindrome3(1221));
        System.out.println(isPalindrome.isPalindrome3(-121));
        System.out.println(isPalindrome.isPalindrome3(10));
        System.out.println(isPalindrome.isPalindrome3(0));

        System.out.println(isPalindrome.isPalindrome4(121));
        System.out.println(isPalindrome.isPalindrome4(1221));
        System.out.println(isPalindrome.isPalindrome4(-121));
        System.out.println(isPalindrome.isPalindrome4(10));
        System.out.println(isPalindrome.isPalindrome4(0));
    }
}
