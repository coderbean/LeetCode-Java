package leetcode._27_;

class Solution {
    public int removeElement(int[] nums, int val) {
        int seat = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[seat++] = nums[i];
            }
        }
        return seat;
    }
}