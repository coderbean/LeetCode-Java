package leetcode._74_;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int width = matrix[0].length;

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