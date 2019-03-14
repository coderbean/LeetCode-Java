package leetcode._33_;

import java.util.Arrays;

class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[low]) { //说明low到mid这一段是递增的，不会经过对称线
                if (target >= nums[low] && target <= nums[mid]) { // 如果 target 在 这之间，继续二分即可
                    int result = Arrays.binarySearch(nums, low, mid, target);
                    return result >= 0 ? result : -1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[high]) { // 如果 target 在 这之间，继续二分即可
                    int result = Arrays.binarySearch(nums, mid + 1, high + 1, target);
                    return result >= 0 ? result : -1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}