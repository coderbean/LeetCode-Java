package leetcode._55_;

class Solution { // 问题可以转化为找到可以跳到的最远的距离
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false; // 如果最远距离到达不了当前索引，没有必要继续走了
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }
}