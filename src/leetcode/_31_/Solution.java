package leetcode._31_;

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        this.isDone(nums, 0);
    }

    private boolean isDone(int[] nums, int begin) {
        int end = nums.length;
        if (end - begin < 1) {
            return true;
        }
        if (end - begin == 2) {
            boolean result = nums[end - 1] > nums[begin];
            int temp = nums[end - 1];
            nums[end - 1] = nums[begin];
            nums[begin] = temp;
            return result;
        }
        if (this.isDone(nums, begin + 1)) {
            return true;
        } else {
            int tmp = begin + 1;
            while (tmp < end) {
                if (nums[begin] < nums[tmp]) {
                    int temp = nums[begin];
                    nums[begin] = nums[tmp];
                    nums[tmp] = temp;
                    return true;
                }
                tmp++;
            }
            Arrays.sort(nums, begin, end);
            return false;  // [1,3,5,2,4]
        }
    }
}