### [29\. Divide Two Integers](https://leetcode.com/problems/divide-two-integers/)

Difficulty: **Medium**


Given two integers `dividend` and `divisor`, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing `dividend` by `divisor`.

The integer division should truncate toward zero.

**Example 1:**

```
Input: dividend = 10, divisor = 3
Output: 3```

**Example 2:**

```
Input: dividend = 7, divisor = -3
Output: -2```

**Note:**

*   Both dividend and divisor will be 32-bit signed integers.
*   The divisor will never be 0.
*   Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2<sup>31</sup>,  2<sup>31</sup> − 1]. For the purpose of this problem, assume that your function returns 2<sup>31</sup> − 1 when the division result overflows.


#### Solution

Language: **Java**

```java
class Solution {
    public int divide(int dividend, int divisor) {
        boolean positive = false;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            positive = true;
        }
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);
​
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
```