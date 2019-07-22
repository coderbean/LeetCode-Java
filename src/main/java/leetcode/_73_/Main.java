package leetcode._73_;

import leetcode.common.Printer;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[][] matrix = {
        //         {1, 1, 1},
        //         {1, 0, 1},
        //         {1, 1, 1}};
        int[][] martix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        Printer.printArrays(martix);
        solution.setZeroes(martix);
        Printer.printArrays(martix);


        int[][] martix2 = {{1,0,3}};
        solution.setZeroes(martix2);
        Printer.printArrays(martix2);
    }
}

