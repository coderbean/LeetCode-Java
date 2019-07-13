package leetcode._59_;

class Solution {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        int[][] matrix = new int[n][n];
        int x = 0; // 需要填充的坐标
        int y = 0; // 需要填充的坐标
        int direction = 0; // 0-右 1-下 2-左 3-上
        for (int i = 1; i <= n * n; i++) {
            matrix[x][y] = i; // 写
            // 判断下一个位置走向，索引定位到下一个位置
            switch (direction) {
                case 0:
                    if (available(matrix, n, x, y + 1)) {
                        y++;
                    } else {
                        direction = 1;
                        x++;
                    }
                    break;
                case 1:
                    if (available(matrix, n, x + 1, y)) {
                        x++;
                    } else {
                        direction = 2;
                        y--;
                    }
                    break;
                case 2:
                    if (available(matrix, n, x, y - 1)) {
                        y--;
                    } else {
                        direction = 3;
                        x--;
                    }
                    break;
                case 3:
                    if (available(matrix, n, x - 1, y)) {
                        x--;
                    } else {
                        direction = 0;
                        y++;
                    }
                    break;
            }
        }
        return matrix;
    }

    /**
     * 判断坐标是否可用
     *
     * @param n 大小
     * @param x 横坐标
     * @param y 纵坐标
     * @return 是否可用
     */
    private boolean available(int[][] matrix, int n, int x, int y) {
        return !(x >= n || y >= n || x < 0 || y < 0 || matrix[x][y] > 0);
    }
}