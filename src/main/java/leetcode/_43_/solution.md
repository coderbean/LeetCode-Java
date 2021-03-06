### [43\. Multiply Strings](https://leetcode.com/problems/multiply-strings/)

Difficulty: **Medium**


Given two non-negative integers `num1` and `num2` represented as strings, return the product of `num1` and `num2`, also represented as a string.

**Example 1:**

```
Input: num1 = "2", num2 = "3"
Output: "6"```

**Example 2:**

```
Input: num1 = "123", num2 = "456"
Output: "56088"
```

**Note:**

1.  The length of both `num1` and `num2` is < 110.
2.  Both `num1` and `num2` contain only digits `0-9`.
3.  Both `num1` and `num2` do not contain any leading zero, except the number 0 itself.
4.  You **must not use any built-in BigInteger library** or **convert the inputs to integer** directly.


#### Solution

Language: **Java**

```java
import java.math.BigDecimal;
​
class Solution {
    public String multiply(String num1, String num2) {
        return new BigDecimal(num1).multiply(new BigDecimal(num2)).toString();
    }
}
```
![](https://ws2.sinaimg.cn/large/006tKfTcgy1g1h7hkk2idj310m0oyjv9.jpg)