package leetcode._11_;

/**
 * Created by zhangbo54 on 2019-03-01.
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        // Integer.parseInt("1" + Integer.MAX_VALUE);
    }

    static
    class Solution {
        public int maxArea(int[] height) {
            int i = 0;
            int j = height.length - 1;
            int water = 0;
            while (i < j) {
                water = Math.max((j - i) * Math.min(height[i], height[j]), water);
                if (height[i] < height[j]) {
                    i++;
                } else {
                    j--;
                }
            }
            return water;
        }
    }
}
