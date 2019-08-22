package leetcode._70_;

/**
 * Created by jacob on 2019-08-20.
 */
public class Solution2 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i <= 2) {
                dp[i] = i;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }
}
