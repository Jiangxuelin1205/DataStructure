package SegmentTree;

import java.util.Arrays;

/**
 * Given an integer array nums,
 * find the sum of the elements
 * between indices i and j (i ≤ j), inclusive.
 */
class NumArray {
    //使用前缀和算法
    private int[] prefix;
    private int[] data;

    NumArray(int[] nums) {
        int sum = 0;
        prefix = new int[nums.length];
        data=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefix[i] = sum + nums[i];
            data[i] = nums[i];
            sum += nums[i];
        }
    }

    int sumRange(int i, int j) {
        return prefix[j]-prefix[i]+data[i];
    }
}
