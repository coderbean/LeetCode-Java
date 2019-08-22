### [16\. 3Sum Closest](https://leetcode.com/problems/3sum-closest/)

Difficulty: **Medium**


Given an array `nums` of _n_ integers and an integer `target`, find three integers in `nums` such that the sum is closest to `target`. Return the sum of the three integers. You may assume that each input would have exactly one solution.

**Example:**

```
Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2\. (-1 + 2 + 1 = 2).
```


#### Solution

Language: **Java**

```java
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        if (nums.length < 3) {
            return sum;
        }
        Arrays.sort(nums);
        int minGap = nums[0] + nums[1] + nums[2] - target;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0 && nums[i] > target) {
                continue;
            }
            if (i > 1 && nums[i] == nums[i - 1]) {
                continue;
            }
            int numSum = target - nums[i];
            int x = i + 1;
            int y = nums.length - 1;
            while (x < y ) {
                int tempSum = nums[x] + nums[y];
                if (tempSum == numSum) {
                    return target;
                } else {
                    if (Math.abs(minGap) > Math.abs(tempSum - numSum)) {
                        minGap = tempSum - numSum;
                    }
                    if (tempSum > numSum) {
                        y--;
                    } else {
                        x++;
                    }
                }
            }
        }
        return minGap + target;
    }
}
                    if (Math.abs(gap) > Math.abs(tempSum - numSum)) {
```