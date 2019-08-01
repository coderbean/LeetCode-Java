package leetcode._88_;

import leetcode.common.Printer;

/**
 * Created by zhangbo54 on 2019-03-04.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        solution.merge2(nums1, 3, nums2, 3);
        Printer.printArrays(nums1);
    }
}

