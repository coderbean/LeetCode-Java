### [46\. Permutations](https://leetcode.com/problems/permutations/)

Difficulty: **Medium**


Given a collection of **distinct** integers, return all possible permutations.

**Example:**

```
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
```


#### Solution

Language: **Java**

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length == 0) {
            return lists;
        }
        if (nums.length == 1) {
            List<Integer> item = new ArrayList<>();
            item.add(nums[0]);
            lists.add(item);
            return lists;
        }
        List<List<Integer>> permute = this.permute(Arrays.copyOfRange(nums, 1, nums.length));
        for (List<Integer> integers : permute) {
            for (int i = 0; i <= integers.size(); i++) {
                ArrayList<Integer> integers1 = new ArrayList<>(integers);
                integers1.add(i, nums[0]);
                lists.add(integers1);
            }
        }
        return lists;
    }
}
```