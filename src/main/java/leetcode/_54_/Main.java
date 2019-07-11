package leetcode._54_;

import java.util.List;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        List<Integer> integers = solution.spiralOrder(matrix);
        System.out.println(integers);
    }
}

