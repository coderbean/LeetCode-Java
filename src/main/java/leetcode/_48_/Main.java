package leetcode._48_;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] arrays = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        solution.rotate(arrays);
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                System.out.print(arrays[i][j] + ",");
            }
            System.out.println("");
        }
        System.out.println(arrays);
    }
}

