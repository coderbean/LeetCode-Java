### [88\. Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)

Difficulty: **Easy**


Given two sorted integer arrays _nums1_ and _nums2_, merge _nums2_ into _nums1_ as one sorted array.

**Note:**

*   The number of elements initialized in _nums1_ and _nums2_ are _m_ and _n_ respectively.
*   You may assume that _nums1_ has enough space (size that is greater or equal to _m_ + _n_) to hold additional elements from _nums2_.

**Example:**

```
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
```


#### Solution

Language: **Java**

```java
class Solution {
    // public void merge(int[] nums1, int m, int[] nums2, int n) {
    //     for (int i = m; i < m + n; i++) {
    //         nums1[i] = nums2[i - m];
    //     }
    //     Arrays.sort(nums1);
    // }
​
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int x = m - 1;
        int y = n - 1;
        int i = m + n - 1;
        while (x > -1 && y > -1) {
            nums1[i--] = nums1[x] > nums2[y] ? nums1[x--] : nums2[y--];
        }
        while (y > -1) {
            nums1[i--] = nums2[y--];
        }
    }
}
```
![pic](https://raw.githubusercontent.com/PicGoBed/PicBed/master/2019-08-01-RSu1Dg.jpg)