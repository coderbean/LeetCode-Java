### [47\. Permutations II](https://leetcode.com/problems/permutations-ii/)

Difficulty: **Medium**


Given a collection of numbers that might contain duplicates, return all possible unique permutations.

**Example:**

```
Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
```


#### Solution

Language: **Java**

```java
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Set<List<Integer>> listSet = new HashSet<>();
        if (nums.length == 0) {
            return lists;
        }
        if (nums.length == 1) {
            List<Integer> item = new ArrayList<>();
            item.add(nums[0]);
            lists.add(item);
            return lists;
        }
        List<List<Integer>> permute = this.permuteUnique(Arrays.copyOfRange(nums, 1, nums.length));
        for (List<Integer> integers : permute) {
            for (int i = 0; i <= integers.size(); i++) {
                ArrayList<Integer> integers1 = new ArrayList<>(integers);
                integers1.add(i, nums[0]);
                if (!listSet.contains(integers1)) {
                    lists.add(integers1);
                    listSet.add(integers1);
                }
            }
        }
        return lists;
    }
}
```