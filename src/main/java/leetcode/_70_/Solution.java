package leetcode._70_;

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return this.climbStairs(dp, n);
    }

    private int climbStairs(int[] dp, int n) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] > 0) {
            return dp[n];
        }
        int num = climbStairs(dp, n - 1) + climbStairs(dp, n - 2);
        dp[n] = num;
        return num;
    }
}