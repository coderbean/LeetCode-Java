package leetcode._88_;

import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int x = m - 1;
        int y = n - 1;
        int i = m + n - 1;
        while (x > -1 && y > -1) {
            nums1[i--] = nums1[x] > nums2[y] ? nums1[x--] : nums2[y--];
        }
        while (y > -1) {
            nums1[i--] = nums2[y--];
        }

    }
}