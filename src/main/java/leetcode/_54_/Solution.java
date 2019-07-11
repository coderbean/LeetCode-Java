package leetcode._54_;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> trace = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return trace;
        }
        int height = matrix.length;
        int wide = matrix[0].length;
        boolean[][] marked = new boolean[matrix.length][matrix[0].length];
        int moveDirection = 0;// 走一个 0-右 1-下 2-左 3-上 的轨迹
        int i = 0;
        int j = 0;
        do {
            trace.add(matrix[i][j]);
            marked[i][j] = true;
            switch (moveDirection) { // 确定下一步的路径绘制方向
                case 0:
                    if (j + 1 >= wide || marked[i][j + 1]) {
                        moveDirection += 1;
                        i++;
                    } else {
                        j++;
                    }
                    break;
                case 1:
                    if (i + 1 >= height || marked[i + 1][j]) {
                        moveDirection += 1;
                        j--;
                    } else {
                        i++;
                    }
                    break;
                case 2:
                    if (j - 1 < 0 || marked[i][j - 1]) {
                        moveDirection += 1;
                        i--;
                    } else {
                        j--;
                    }
                    break;
                case 3:
                    if (i - 1 < 0 || marked[i - 1][j]) {
                        moveDirection = 0;
                        j++;
                    } else {
                        i--;
                    }
                    break;
                default:
                    break;
            }

        } while (avaliable(marked, i, j + 1)
                || avaliable(marked, i + 1, j)
                || avaliable(marked, i, j - 1)
                || avaliable(marked, i - 1, j));
        if (i >= 0 && i < height && j >= 0 && j < wide) { // 如果最后一个存在，加入。
            trace.add(matrix[i][j]);
        }
        return trace;
    }

    private boolean avaliable(boolean[][] marked, int i, int j) {
        if (i >= marked.length || j >= marked[0].length || i < 0 || j < 0) {
            return false;
        }
        return !marked[i][j];
    }
}