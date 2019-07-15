### [62\. Unique Paths](https://leetcode.com/problems/unique-paths/)

Difficulty: **Medium**


A robot is located at the top-left corner of a _m_ x _n_ grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

![](https://assets.leetcode.com/uploads/2018/10/22/robot_maze.png)  
<small style="display: inline;">Above is a 7 x 3 grid. How many possible unique paths are there?</small>

**Note:** _m_ and _n_ will be at most 100.

**Example 1:**

```
Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1\. Right -> Right -> Down
2\. Right -> Down -> Right
3\. Down -> Right -> Right
```

**Example 2:**

```
Input: m = 7, n = 3
Output: 28
```


#### Solution

Language: **Java**

```java
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] ways = new int[m + 1][n + 1]; // 所有的格子都能到达，因此初始化为0，表示没有计算过。该数组用于保存到达该坐标的路径个数，防止重复计算
        return uniquePaths(ways, m, n);
    }
​
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
```
这里第一次提交超时了，由于没考虑重复计算的问题，造成如果棋盘很大的情况下，会导致重复计算问题明显。
![](http://ww4.sinaimg.cn/large/006tNc79ly1g51045ecr4j31b40q643d.jpg)