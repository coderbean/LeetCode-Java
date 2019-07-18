### [64\. Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)

Difficulty: **Medium**


Given a _m_ x _n_ grid filled with non-negative numbers, find a path from top left to bottom right which _minimizes_ the sum of all numbers along its path.

**Note:** You can only move either down or right at any point in time.

**Example:**

```
Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
```


#### Solution

Language: **Java**

```java
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
```
![](https://raw.githubusercontent.com/coderbean/PicBed/master/20190718190913.png)