### [74\. Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/)

Difficulty: **Medium**


Write an efficient algorithm that searches for a value in an _m_ x _n_ matrix. This matrix has the following properties:

*   Integers in each row are sorted from left to right.
*   The first integer of each row is greater than the last integer of the previous row.

**Example 1:**

```
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
```

**Example 2:**

```
Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
```


#### Solution

Language: **Java**

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int width = matrix[0].length;
​
        if (width == 0) {
            return false;
        }
        int targetRowIndex = -1;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] <= target && matrix[i][width - 1] >= target) {
                targetRowIndex = i;
                break;
            }
        }
        if (targetRowIndex < 0) {
            return false;
        }
        int[] targetRow = matrix[targetRowIndex];
​
        int left = 0;
        int right = width;
        int medium;
        while (left < right) {
            medium = (left + right) / 2;
            if (targetRow[medium] == target) {
                return true;
            } else if (targetRow[medium] > target) {
                right = medium;
            } else {
                left = medium + 1;
            }
        }
        return false;
    }
}
```
![pic](https://gitee.com/jacobchang/PicBed/raw/master/HGYqH5.png)