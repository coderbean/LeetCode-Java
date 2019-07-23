### [51\. N-Queens](https://leetcode.com/problems/n-queens/)

Difficulty: **Hard**


The _n_-queens puzzle is the problem of placing _n_ queens on an _n_×_n_ chessboard such that no two queens attack each other.

![](https://assets.leetcode.com/uploads/2018/10/12/8-queens.png)

Given an integer _n_, return all distinct solutions to the _n_-queens puzzle.

Each solution contains a distinct board configuration of the _n_-queens' placement, where `'Q'` and `'.'` both indicate a queen and an empty space respectively.

**Example:**

```
Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
```


#### Solution

Language: **Java**

```java
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        LinkedList<Integer> column = new LinkedList<>();
        LinkedList<Integer> pie = new LinkedList<>();
        LinkedList<Integer> na = new LinkedList<>();
        this.DFS(column, pie, na,
                0, n, result, new ArrayList<>());
        return result;
    }
​
    private void DFS(LinkedList<Integer> column, LinkedList<Integer> pie, LinkedList<Integer> na,
                     int row, int n, List<List<String>> result, List<String> currStat) {
        if (row >= n) {
            result.add(currStat);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (column.contains(i) || pie.contains(i + row) || na.contains(row - i)) {
                continue;
            }
            // 记录皇后可以攻击的点
            column.add(i);
            pie.add(i + row);
            na.add(row - i);
​
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    stringBuilder.append("Q");
                } else {
                    stringBuilder.append(".");
                }
            }
            this.DFS(column, pie, na, row + 1, n, result, new ArrayList<String>(currStat) {{
                add(stringBuilder.toString());
            }});
            // 移除，便于下一次回溯
            column.pollLast();
            pie.pollLast();
            na.pollLast();
        }
    }
}
```
![pic](https://gitee.com/jacobchang/PicBed/raw/master/2019-07-23-f66Gm8.png)