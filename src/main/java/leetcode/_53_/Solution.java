package leetcode._53_;

class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length]; // 表示以 index 为结尾的，最大子序列和的值
        dp[0] = nums[0];
        int maxSum = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            maxSum = dp[i] > maxSum ? dp[i] : maxSum;
        }
        return maxSum;
    }
}