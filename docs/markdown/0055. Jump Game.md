### [55\. Jump Game](https://leetcode.com/problems/jump-game/)

Difficulty: **Medium**


Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

**Example 1:**

```
Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
```

**Example 2:**

```
Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
```


#### Solution

Language: **Java**

```java
class Solution { // 问题可以转化为找到可以跳到的最远的距离
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false; // 如果最远距离到达不了当前索引，没有必要继续走了
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }
}
```
![](http://ww1.sinaimg.cn/large/006tNc79ly1g4x1rsw78jj318w0u0gqu.jpg)