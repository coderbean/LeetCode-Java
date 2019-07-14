### [18\. 4Sum](https://leetcode.com/problems/4sum/)

Difficulty: **Medium**


Given an array `nums` of _n_ integers and an integer `target`, are there elements _a_, _b_, _c_, and _d_ in `nums` such that _a_ + _b_ + _c_ + _d_ = `target`? Find all unique quadruplets in the array which gives the sum of `target`.

**Note:**

The solution set must not contain duplicate quadruplets.

**Example:**

```
Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
```


#### Solution

Language: **Java**

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>(); // 一开始写的是list，不过这个去重真的是很麻烦，还是使用set来去重了
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int targetSum = target - (nums[i] + nums[j]);
                if (targetSum < nums[j] && nums[j] > 0) { // 因为已经排序了，所以后面的任意两个数和必然大于 targetSum
                    break;
                }
                for (int x = j + 1, y = nums.length - 1; x < y; ) {
                    if (nums[x] + nums[y] > targetSum) {
                        y--;
                    } else if (nums[x] + nums[y] < targetSum) {
                        x++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[x], nums[y]));
                        x++;
                        y--;
​
                        while (x < y && x >= 1 && nums[x] == nums[x - 1]) {
                            x++;
                        }
                        while (x < y && y + 1 < nums.length && nums[y] == nums[y + 1]) {
                            y--;
                        }
                    }
                }
​
            }
        }
        return new ArrayList<>(result);
    }
}
```
![](https://ws1.sinaimg.cn/large/006tKfTcgy1g0sy56zmtdj30v90u0gq9.jpg)
