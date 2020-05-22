package com.sid.leetcode;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 **/

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int l = nums.length;
        int dp[] = new int[l], max = Integer.MIN_VALUE;
        dp[0] = nums[0];
        for (int i = 1; i < l; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxSubArrayV2(int[] nums) {
        int l = nums.length;
        int max = nums[0], prev_Sum = nums[0];
        for (int i = 1; i < l; i++) {
            prev_Sum = Math.max(prev_Sum + nums[i], nums[i]);
            max = Math.max(max, prev_Sum);
        }
        return max;
    }

    public int maxSubArrayV3(int[] nums) {
        if (nums.length == 1) return nums[0];
        return _findUsingDivideAndConquer(nums, 0, nums.length - 1);
    }

    private int _findUsingDivideAndConquer(int[] nums, int l, int h) {
        if (l >= h) return nums[l];
        int mid = (l + h) >> 1;
        int leftSubArraySum = _findUsingDivideAndConquer(nums, l, mid);
        System.out.println(leftSubArraySum);
        int rightSubArraySum = _findUsingDivideAndConquer(nums, mid + 1, h);
        System.out.println(rightSubArraySum);
        int crossOverSubArraySum = _findCrossSubArraySum(nums, l, mid, h);
        System.out.println(crossOverSubArraySum);
        return Math.max(crossOverSubArraySum, Math.max(leftSubArraySum, rightSubArraySum));
    }

    private int _findCrossSubArraySum(int[] nums, int l, int mid, int h) {
        int sum = 0;
        int left = nums[mid];
        for (int i = mid; i >= l; i--) {
            sum = +nums[i];
            if (sum > left)
                left = sum;
        }
        int right = nums[mid + 1];
        sum = 0;
        for (int i = mid + 1; i <= h; i++) {
            sum += nums[i];
            if (sum > right)
                right = sum;
        }
        return left + right;
    }


    public static void main(String[] args) {
        int[] n = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new MaximumSubarray().maxSubArrayV3(n));
    }
}
