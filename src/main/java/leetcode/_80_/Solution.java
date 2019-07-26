package leetcode._80_;

class Solution { // 当看到这个解法的时候，我只能说一句：真 tmd 牛逼
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i++] = num;
            }
        }
        return i;
    }
}