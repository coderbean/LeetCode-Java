### [66\. Plus One](https://leetcode.com/problems/plus-one/)

Difficulty: **Easy**


Given a **non-empty** array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

**Example 1:**

```
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
```

**Example 2:**

```
Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
```


#### Solution

Language: **Java**

```java
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            int[] result = {1};
            return result;
        }
        int plusNum = 1;
        for (int i = digits.length - 1; i >= 0 && plusNum > 0; i--) {
            int newNum = digits[i] + plusNum;
            plusNum = newNum / 10;
            digits[i] = newNum % 10;
        }
        if (plusNum > 0) {
            int[] result = new int[digits.length + 1];
            result[0] = plusNum;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }
        return digits;
    }
}
```
![](https://raw.githubusercontent.com/PicGoBed/PicBed/master/20190719172019.png)