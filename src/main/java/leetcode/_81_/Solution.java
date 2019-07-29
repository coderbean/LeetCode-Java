package leetcode._81_;

import java.util.Arrays;

class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle;
        while (low <= high) {
            middle = (high + low) / 2;
            if (nums[middle] == target) {
                return true;
            }
            if (nums[low] < nums[middle] || nums[high] < nums[middle]) { // [low,middle]是升序 或者是[middle,high]
                if (target >= nums[low] && nums[middle] >= target) { // 普通二分查找就能得到结果
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }

            } else if (nums[high] > nums[middle] || nums[low] > nums[middle]) { // [low,middle] 必然有对称点
                if (target <= nums[high] && nums[middle] <= target) { // 普通二分查找就能得到结果
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }

            } else { // nums[low] == nums[middle] 无法判断是升序还是有对称点
                high--;
            }
        }
        return false;
    }
}