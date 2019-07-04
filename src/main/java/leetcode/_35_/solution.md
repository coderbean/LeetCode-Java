### [35\. Search Insert PositionCopy for MarkdownCopy for MarkdownCopy for MarkdownCopy for Markdown](https://leetcode.com/problems/search-insert-position/)

Difficulty: **Easy**


Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

**Example 1:**

```
Input: [1,3,5,6], 5
Output: 2
```

**Example 2:**

```
Input: [1,3,5,6], 2
Output: 1
```

**Example 3:**

```
Input: [1,3,5,6], 7
Output: 4
```

**Example 4:**

```
Input: [1,3,5,6], 0
Output: 0
```


#### Solution

Language: **Java**

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        return index < 0 ? -index - 1 : index;
    }
}
```
![](https://ws3.sinaimg.cn/large/006tKfTcgy1g13koxtxs3j31160ra0wl.jpg)