package leetcode._74_;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                {
                        1, 3, 5, 7
                },
                {
                        10, 11, 16, 20
                },
                {
                        23, 30, 34, 50
                }
        };
        System.out.println(solution.searchMatrix(matrix, 3));

        int[][] matrix2 = {
                {
                        1, 3, 5, 7
                },
                {
                        10, 11, 16, 20
                },
                {
                        23, 30, 34, 50
                }
        };
        System.out.println(solution.searchMatrix(matrix2, 13));
        int[][] matrix3 = {
                {
                        1
                }
        };
        System.out.println(solution.searchMatrix(matrix3, 0));

    }
}

