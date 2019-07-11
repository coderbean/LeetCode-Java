### [53\. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)

Difficulty: **Easy**


Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

**Example:**

```
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

**Follow up:**

If you have figured out the O(_n_) solution, try coding another solution using the divide and conquer approach, which is more subtle.


#### Solution

Language: **Java** 参考

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length]; // 表示以 index 为结尾的，最大子序列和的值
        dp[0] = nums[0];
        int maxSum = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            maxSum = dp[i] > maxSum ? dp[i] : maxSum;
        }
        return maxSum;
    }
}
```