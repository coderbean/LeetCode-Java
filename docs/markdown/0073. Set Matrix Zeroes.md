### [73\. Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/)

Difficulty: **Medium**


Given a _m_ x _n_ matrix, if an element is 0, set its entire row and column to 0\. Do it .

**Example 1:**

```
Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
```

**Example 2:**

```
Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
```

**Follow up:**

*   A straight forward solution using O(_m__n_) space is probably a bad idea.
*   A simple improvement uses O(_m_ + _n_) space, but still not the best solution.
*   Could you devise a constant space solution?


#### Solution

Language: **Java**

```java
class Solution {
    public void setZeroes(int[][] matrix) {
        int row0 = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        row0 = 0;
                    } else {
                        matrix[i][0] = 0;
                    }
                    matrix[0][j] = 0; // 表示第 j 列
                }
            }
        }
        for (int i = matrix.length - 1; i >= 1; i--) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0 == 0) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}
```
![](https://raw.githubusercontent.com/PicGoBed/PicBed/master/20190722143115.png)