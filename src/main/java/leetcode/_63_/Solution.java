package leetcode._63_;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        int[][] ways = new int[m][n]; // 所有的格子都能到达，因此初始化为0，表示没有计算过。该数组用于保存到达该坐标的路径个数，防止重复计算
        int i = uniquePathsWithObstacles(obstacleGrid, ways, m - 1, n - 1);
        return i;
    }

    private int uniquePathsWithObstacles(int[][] obstacleGrid, int[][] ways, int m, int n) {
        if (m < 0 || n < 0 || obstacleGrid[m][n] == 1) {
            return 0;
        }
        if (m + n == 0) {
            ways[m][n] = 1;
            return 1;
        }
        if (ways[m][n] > 0) {
            return ways[m][n];
        }
        ways[m][n] = uniquePathsWithObstacles(obstacleGrid, ways, m, n - 1) + uniquePathsWithObstacles(obstacleGrid, ways, m - 1, n);
        return ways[m][n];
    }
}