package leetcode._62_;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] ways = new int[m + 1][n + 1]; // 所有的格子都能到达，因此初始化为0，表示没有计算过。该数组用于保存到达该坐标的路径个数，防止重复计算
        return uniquePaths(ways, m, n);
    }

    private int uniquePaths(int[][] ways, int m, int n) {
        if (ways[m][n] > 0) {
            return ways[m][n];
        }
        if (m * n == 0) {
            ways[m][n] = 0;
            return 0;
        }
        if (m == 1 || n == 1) {
            ways[m][n] = 1;
            return 1;
        }
        ways[m][n] = uniquePaths(ways, m, n - 1) + uniquePaths(ways, m - 1, n);
        return ways[m][n];
    }
}