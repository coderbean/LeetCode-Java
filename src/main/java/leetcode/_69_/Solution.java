package leetcode._69_;

class Solution {
    public int mySqrt(int x) {
        int left = 0; // 二分法
        int right = x;
        int medium = (left + right) / 2;
        while (left <= right) {
            if (medium == 0) {
                return right;
            }
            int target = x / medium;
            if (medium == target || medium == target + 1) {
                return target;
            } else if (target < medium) {
                right = medium;
            } else if (target > medium - 1) {
                left = medium + 1;
            }
            medium = (left + right) / 2;
        }
        return 0;
    }
}