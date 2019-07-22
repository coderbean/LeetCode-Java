### [75\. Sort Colors](https://leetcode.com/problems/sort-colors/)

Difficulty: **Medium**


Given an array with _n_ objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

**Note:** You are not suppose to use the library's sort function for this problem.

**Example:**

```
Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
```

**Follow up:**

*   A rather straight forward solution is a two-pass algorithm using counting sort.  
    First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
*   Could you come up with a one-pass algorithm using only constant space?


#### Solution

Language: **Java**

```java
class Solution {
    public void sortColors(int[] nums) { // 搞个堆排序吧
        // 第一步，build heap
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            heapify(nums, i, nums.length);
        }
        // 第二步， heap sort
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
    }
​
    // 这里第三个参数的目的是在堆排序阶段，最后面的值是已经排序出来的，因此不参与 heapify 了
    private void heapify(int[] nums, int index, int length) {
        int lc = index * 2 + 1;
        int rc = lc + 1;
        int maxc = lc;
        if (lc >= length) {
            return;
        }
        if (rc < length && nums[lc] < nums[rc]) {
            maxc = rc;
        }
        if (nums[maxc] > nums[index]) {
            swap(nums, index, maxc);
            this.heapify(nums, maxc, length);
        }
    }
​
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
```
![pic](https://gitee.com/jacobchang/PicBed/raw/master/srV1na.png)