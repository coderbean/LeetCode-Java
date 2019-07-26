package leetcode._80_;

import leetcode.common.Printer;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(solution.removeDuplicates(nums));
        Printer.printArrays(nums);


        int[] nums1 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(solution.removeDuplicates(nums1));
        Printer.printArrays(nums1);

    }
}

