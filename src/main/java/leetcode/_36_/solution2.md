### [36\. Valid SudokuCopy for MarkdownCopy for MarkdownCopy for Markdown](https://leetcode.com/problems/valid-sudoku/)

Difficulty: **Medium**


Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated **according to the following rules**:

1.  Each row must contain the digits `1-9` without repetition.
2.  Each column must contain the digits `1-9` without repetition.
3.  Each of the 9 `3x3` sub-boxes of the grid must contain the digits `1-9` without repetition.

![](https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Sudoku-by-L2G-20050714.svg/250px-Sudoku-by-L2G-20050714.svg.png)  
<small style="display: inline;">A partially filled sudoku which is valid.</small>

The Sudoku board could be partially filled, where empty cells are filled with the character `'.'`.

**Example 1:**

```
Input:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: true
```

**Example 2:**

```
Input:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being 
    modified to 8\. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
```

**Note:**

*   A Sudoku board (partially filled) could be valid but is not necessarily solvable.
*   Only the filled cells need to be validated according to the mentioned rules.
*   The given board contain only digits `1-9` and the character `'.'`.
*   The given board size is always `9x9`.


#### Solution

Language: **Java**

```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    if (!seen.add(num + " in row " + i)
                            || !seen.add(num + " in column " + j)
                            || !seen.add(num + " in block " + i / 3 + "," + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
​
```
![](https://ws1.sinaimg.cn/large/006tKfTcgy1g1ajv1n01vj30zo0lc77f.jpg)