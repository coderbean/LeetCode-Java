package leetcode._34_;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 0) {
            return result;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        if (nums[i] != target)
            return result;
        result[0] = i;
        j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2 + 1; // 中位数偏右，避免上面的判断无法跳出循环
            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid;
            }
        }
        if (nums[j] == target) {
            result[1] = j;
        }
        return result;
    }
}