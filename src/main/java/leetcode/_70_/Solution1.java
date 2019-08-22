package leetcode._70_;

/**
 * Created by jacob on 2019-08-20.
 */
public class Solution1 {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
