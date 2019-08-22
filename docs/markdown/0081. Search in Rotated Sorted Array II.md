### [81\. Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)

Difficulty: **Medium**


Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., `[0,0,1,2,2,5,6]` might become `[2,5,6,0,0,1,2]`).

You are given a target value to search. If found in the array return `true`, otherwise return `false`.

**Example 1:**

```
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
```

**Example 2:**

```
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false```

**Follow up:**

*   This is a follow up problem to , where `nums` may contain duplicates.
*   Would this affect the run-time complexity? How and why?


#### Solution

Language: **Java**

```java
class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int middle;
        while (low <= high) {
            middle = (high + low) / 2;
            if (nums[middle] == target) {
                return true;
            }
            if (nums[low] < nums[middle] || nums[high] < nums[middle]) { // [low,middle]是升序 或者是[middle,high]
                if (target >= nums[low] && nums[middle] >= target) { // 普通二分查找就能得到结果
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
​
            } else if (nums[high] > nums[middle] || nums[low] > nums[middle]) { // [low,middle] 必然有对称点
                if (target <= nums[high] && nums[middle] <= target) { // 普通二分查找就能得到结果
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
​
            } else { // nums[low] == nums[middle] 无法判断是升序还是有对称点
                high--;
            }
        }
        return false;
    }
}
```
![pic](https://raw.githubusercontent.com/PicGoBed/PicBed/master/2019-07-29-fwUbnO.jpg)