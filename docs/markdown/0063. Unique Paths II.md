### [63\. Unique Paths II](https://leetcode.com/problems/unique-paths-ii/)

Difficulty: **Medium**


A robot is located at the top-left corner of a _m_ x _n_ grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

![](https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png)

An obstacle and empty space is marked as `1` and `0` respectively in the grid.

**Note:** _m_ and _n_ will be at most 100.

**Example 1:**

```
Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1\. Right -> Right -> Down -> Down
2\. Down -> Down -> Right -> Right
```


#### My Solution

Language: **Java**

```java
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
​
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
```

#### Recommend Solution

Language: **Java**

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }

    // dp[j] += dp[j - 1];
    // is
    // dp[j] = dp[j] + dp[j - 1];

    // which is new dp[j] = old dp[j] + dp[j-1]
    // which is current cell = top cell + left cell
}
```
![](https://image-hosting-1251780645.cos.ap-beijing.myqcloud.com/20190717000607.png)