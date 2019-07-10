### [50\. Pow(x, n)](https://leetcode.com/problems/powx-n/)

Difficulty: **Medium**


Implement , which calculates _x_ raised to the power _n_ (x<sup><span style="font-size: 10.8333px; display: inline;">n</span></sup>).

**Example 1:**

```
Input: 2.00000, 10
Output: 1024.00000
```

**Example 2:**

```
Input: 2.10000, 3
Output: 9.26100
```

**Example 3:**

```
Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
```

**Note:**

*   -100.0 < _x_ < 100.0
*   _n_ is a 32-bit signed integer, within the range [−2<sup>31</sup>, 2<sup>31 </sup>− 1]


#### Solution

Language: **Java**

```java
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) { // 任何数的零次幂都是 1
            return 1;
        }
        if (n < 0) { // 如果 n 是负数，先把负数提到 x 里面，然后再计算
            if (n == Integer.MIN_VALUE) {
                n++;  // 这里需要考虑 INT_MAX < -INT_MIN ，防止溢出
                x = x * x;// 同时需要把少乘的那个数字乘进去
            }
            n = -n; // 这里需要考虑 INT_MAX < -INT_MIN ，所以需要处理一下
            x = 1 / x;
        }
        // 递归
        return (n % 2 == 0) ? myPow(x * x, n >> 1) : x * myPow(x * x, n >> 1);
    }
}
```
![](http://ww1.sinaimg.cn/large/006tNc79ly1g4v32p2fbsj30v10u0dnf.jpg)