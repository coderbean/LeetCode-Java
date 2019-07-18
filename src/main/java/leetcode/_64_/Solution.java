package leetcode._64_;

class Solution {
    public int minPathSum(int[][] grid) {
        int width = grid[0].length;
        int[] dp = new int[width]; // 表示到达该位置的最短路径长度
        for (int i = 0; i < grid.length; i++) {
            int[] ints = grid[i];
            for (int j = 0; j < ints.length; j++) {
                if (j == 0) {
                    dp[0] += ints[j];
                } else {
                    if (i == 0) {
                        dp[j] = dp[j - 1] + ints[j]; // 没有上，直接加
                    } else {
                        dp[j] = Math.min(dp[j - 1], dp[j]) + ints[j]; // 比较选择小的
                    }
                }
            }
        }
        return dp[width - 1];
    }
}