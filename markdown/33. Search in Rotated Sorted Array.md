### [33\. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)

Difficulty: **Medium**


Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., `[0,1,2,4,5,6,7]` might become `[4,5,6,7,0,1,2]`).

You are given a target value to search. If found in the array return its index, otherwise return `-1`.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of _O_(log _n_).

**Example 1:**

```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

**Example 2:**

```
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1```


#### Solution

Language: **Java**

```java
class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[low]) { //说明low到mid这一段是递增的，不会经过对称线
                if (target >= nums[low] && target <= nums[mid]) { // 如果 target 在 这之间，继续二分即可
                    int result = Arrays.binarySearch(nums, low, mid, target);
                    return result >= 0 ? result : -1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[high]) { // 如果 target 在 这之间，继续二分即可
                    int result = Arrays.binarySearch(nums, mid + 1, high + 1, target);
                    return result >= 0 ? result : -1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
```
![](https://ws1.sinaimg.cn/large/006tKfTcgy1g12lb7o7nfj30u00v5wk7.jpg)