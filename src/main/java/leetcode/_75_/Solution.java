package leetcode._75_;

class Solution {
    public void sortColors(int[] nums) { // 搞个堆排序吧
        // 第一步，build heap
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, i, nums.length);
        }
        // 第二步， heap sort
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
    }

    // 这里第三个参数的目的是在堆排序阶段，最后面的值是已经排序出来的，因此不参与 heapify 了
    private void heapify(int[] nums, int index, int length) {
        int lc = index * 2 + 1;
        int rc = lc + 1;
        int maxc = lc;
        if (lc >= length) {
            return;
        }
        if (rc < length && nums[lc] < nums[rc]) {
            maxc = rc;
        }
        if (nums[maxc] > nums[index]) {
            swap(nums, index, maxc);
            this.heapify(nums, maxc, length);
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}