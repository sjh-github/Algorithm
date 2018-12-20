package com.sjh.algorithm.simple.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sjh
 * @date 2018/12/19
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoNum {

    private int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("数组不可为空且数组长度至少为2");
        }

        int[] index = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    index[0] = i;
                    index[1] = j;
                    break;
                }
            }
        }
        return index;
    }

    private int[] twoNum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("数组不可为空且数组长度至少为2");
        }

        int[] index = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                index[0] = i;
                index[1] = map.get(complement);
                break;
            }
        }
        return index;
    }

    private int[] twoNum3(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("数组不可为空且数组长度至少为2");
        }

        int[] index = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                index[0] = i;
                index[1] = map.get(complement);
                break;
            } else {
                map.put(nums[i], i);
            }
        }

        return index;
    }

    public static void main(String[] args) {
        TwoNum twoNum = new TwoNum();
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] index1 = twoNum.twoSum1(nums, target);
        System.out.println(Arrays.toString(index1));

        int[] index2 = twoNum.twoNum2(nums, target);
        System.out.println(Arrays.toString(index2));

        int[] index3 = twoNum.twoNum3(nums, target);
        System.out.println(Arrays.toString(index3));
    }
}
