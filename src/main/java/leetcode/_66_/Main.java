package leetcode._66_;

import leetcode.common.Printer;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] digits = {1, 2, 3};
        int[] ints = solution.plusOne(digits);
        Printer.printArrays(ints);
    }
}

