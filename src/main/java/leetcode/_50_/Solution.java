package leetcode._50_;

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) { // 任何数的零次幂都是 1
            return 1;
        }
        if (n < 0) { // 如果 n 是负数，先把负数提到 x 里面，然后再计算
            if (n == Integer.MIN_VALUE) {
                n++;  // 这里需要考虑 INT_MAX < -INT_MIN ，防止溢出
                x = x * x;// 同时需要把少乘的那个数字乘进去
            }
            n = -n; // 这里需要考虑 INT_MAX < -INT_MIN ，所以需要处理一下
            x = 1 / x;
        }
        // 递归
        return (n % 2 == 0) ? myPow(x * x, n >> 1) : x * myPow(x * x, n >> 1);
    }
}