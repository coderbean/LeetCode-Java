### [69\. Sqrt(x)](https://leetcode.com/problems/sqrtx/)

Difficulty: **Easy**


Implement `int sqrt(int x)`.

Compute and return the square root of _x_, where _x_ is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

**Example 1:**

```
Input: 4
Output: 2
```

**Example 2:**

```
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
```


#### Solution

Language: **Java**

```java
class Solution {
    public int mySqrt(int x) {
        int left = 0;
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
```
![](https://raw.githubusercontent.com/PicGoBed/PicBed/master/20190720170020.png)