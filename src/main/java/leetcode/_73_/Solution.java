package leetcode._73_;

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