### [89\. Gray Code](https://leetcode.com/problems/gray-code/)

Difficulty: **Medium**


The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer _n_ representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

**Example 1:**

```
Input: 2
Output: [0,1,3,2]
Explanation:
00 - 0
01 - 1
11 - 3
10 - 2

For a given n, a gray code sequence may not be uniquely defined.
For example, [0,2,3,1] is also a valid gray code sequence.

00 - 0
10 - 2
11 - 3
01 - 1
```

**Example 2:**

```
Input: 0
Output: [0]
Explanation: We define the gray code sequence to begin with 0.
             A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
             Therefore, for n = 0 the gray code sequence is [0].
```


#### Solution

Language: **Java**

```java
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 0; i < n; i++) {
            for (int j = result.size() - 1; j >= 0; j--) { // 从尾部开始，用于保持连续（即每次只差一个bit位）
                result.add(result.get(j) | 1 << i);
            }
        }
        return result;
    }
}
```
![pic](https://raw.githubusercontent.com/PicGoBed/PicBed/master/2019-08-01-RdPkMU.jpg)