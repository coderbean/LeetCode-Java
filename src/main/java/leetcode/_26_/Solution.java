package leetcode._26_;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = 1;
        int emptyIndex = -1; // 可以放下一个元素的位置
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] && emptyIndex == -1) {
                emptyIndex = i + 1;
            }
            // if (i + 2 == nums.length && emptyIndex == -1){ // 表示全部不重复
            //     return nums.length;
            // }
            if (nums[i] != nums[i + 1]) {
                len++;
                if (emptyIndex!=-1) {
                    nums[emptyIndex++] = nums[i + 1];
                }
            }
        }
        return len;
    }
}