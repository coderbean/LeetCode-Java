### [36\. Valid SudokuCopy for Markdown](https://leetcode.com/problems/valid-sudoku/)

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
        }
        for (int i = 0; i < 9; i++) {
            // every row
            Set<Character> set = new HashSet<>();
            set.addAll(vList.get(i));
            set.addAll(vList.get(i + 9));
            set.addAll(vList.get(i + 9 * 2));
            if (set.size() != (vList.get(i).size() + vList.get(i + 9).size() + vList.get(i + 9 * 2).size())) {
                return false;
            }
​
            // every columns
            Set<Character> set2 = new HashSet<>();
            set2.addAll(hList.get(i));
            set2.addAll(hList.get(i + 9));
            set2.addAll(hList.get(i + 9 * 2));
            if (set2.size() != (hList.get(i).size() + hList.get(i + 9).size() + hList.get(i + 9 * 2).size())) {
                return false;
            }
​
            // every little 9 grips
            Set<Character> set3 = new HashSet<>();
            set3.addAll(vList.get(i * 3));
            set3.addAll(vList.get(i * 3 + 1));
            set3.addAll(vList.get(i * 3 + 2));
            if (set3.size() != (vList.get(i * 3).size() + vList.get(i * 3 + 1).size() + vList.get(i * 3 + 2).size())) {
                return false;
            }
​
        }
        return true;
    }
}
​
```
![](https://ws3.sinaimg.cn/large/006tKfTcgy1g1ajb5r7onj30xk0u0gql.jpg)