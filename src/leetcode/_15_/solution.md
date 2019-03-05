### [15\. 3Sum](https://leetcode.com/problems/3sum/)

Difficulty: **Medium**


Given an array `nums` of _n_ integers, are there elements _a_, _b_, _c_ in `nums` such that _a_ + _b_ + _c_ = 0? Find all unique triplets in the array which gives the sum of zero.

**Note:**

The solution set must not contain duplicate triplets.

**Example:**

```
Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
```


#### Solution

Language: **Java**

```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
​
        Arrays.sort(nums); // 排序用于剔除重复项
        Set<List<Integer>> resultSet = new HashSet<>();
        Map<Integer, List<Integer>> index = new HashMap<>();
        // List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            index.computeIfAbsent(nums[i], k -> new ArrayList<>());
            index.get(nums[i]).add(i);
        }
​
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
​
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (-sum < nums[j] || -sum > nums[nums.length - 1]) {
                    continue;
                }
                List<Integer> integers = Arrays.asList(nums[i], nums[j], -sum);
                if (resultSet.contains(integers)) {
                    continue;
                }
                if (index.get(-sum) != null) {
                    for (Integer integer : index.get(-sum)) {
                        if (integer > j) {
                            resultSet.add(integers);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(resultSet);
    }
}
​
```