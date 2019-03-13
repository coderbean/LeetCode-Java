package leetcode._29_;

class Solution {
    public int divide(int dividend, int divisor) {
        boolean positive = false;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            positive = true;
        }
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        long result = 0;
        while (longDividend >= longDivisor) { // 外层循环用来将剩余的继续算
            long temp = longDivisor;
            long tempResult = 1;
            while (longDividend >= temp) { // 内层循环用来加快速度
                longDividend -= temp;
                result += tempResult;
                tempResult <<= 1;
                temp <<= 1;
            }
        }
        if (positive && result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (!positive && result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return positive ? (int) result : (int) -result;
    }
}