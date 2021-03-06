### [34\. Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

Difficulty: **Medium**


Given an array of integers `nums` sorted in ascending order, find the starting and ending position of a given `target` value.

Your algorithm's runtime complexity must be in the order of _O_(log _n_).

If the target is not found in the array, return `[-1, -1]`.

**Example 1:**

```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]```

**Example 2:**

```
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]```


#### Solution

Language: **Java**

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 0) {
            return result;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        if (nums[i] != target)
            return result;
        result[0] = i;
        j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2 + 1; // 中位数偏右，避免上面的判断无法跳出循环
            if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid;
            }
        }
        if (nums[j] == target) {
            result[1] = j;
        }
        return result;
    }
}
```
![](https://ws4.sinaimg.cn/large/006tKfTcgy1g13hk8nrndj310s0r042m.jpg)