package leetcode._48_;

class Solution { // 解决这个问题的关键就是知道，图像旋转90度是可以通过先对称镜像，然后对角线镜像可以得到旋转结果
    public void rotate(int[][] matrix) {
        // 首先按照水平反转

        for (int j = 0; j < matrix.length / 2; j++) {
            for (int i = 0; i < matrix.length; i++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = tmp;
            }
        }
        // 然后按照对角线反转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
}