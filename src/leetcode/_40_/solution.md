### [40\. Combination Sum IICopy for MarkdownCopy for MarkdownCopy for Markdown](https://leetcode.com/problems/combination-sum-ii/)

Difficulty: **Medium**


Given a collection of candidate numbers (`candidates`) and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sums to `target`.

Each number in `candidates` may only be used **once** in the combination.

**Note:**

*   All numbers (including `target`) will be positive integers.
*   The solution set must not contain duplicate combinations.

**Example 1:**

```
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
```

**Example 2:**

```
Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
```


#### Solution

Language: **Java**

```java
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < candidates.length; i++) {
            if (i > 1 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target == candidates[i]) {
                result.add(Collections.singletonList(target));
            }
            for (List<Integer> list : this.combinationSum2(candidates, i, target - candidates[i])) {
                list.add(candidates[i]);
                result.add(list);
            }
        }
        return new ArrayList<>(result);
    }
​
    private List<List<Integer>> combinationSum2(int[] candidates, int index, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (target < candidates[index]) {
            return result;
        }
        if (Arrays.binarySearch(candidates, index + 1, candidates.length, target) > 0) {
            result.add(new ArrayList<>(Collections.singletonList(target)));
        }
        for (int i = index + 1; i < candidates.length; i++) {
            for (List<Integer> list : this.combinationSum2(candidates, i, target - candidates[i])) {
                list.add(candidates[i]);
                result.add(list);
            }
        }
        return result;
    }
}
            for (List<Integer> list : this.combinationSum2(candidates, i, target - candidates[i])) {
```
![](https://ws3.sinaimg.cn/large/006tKfTcgy1g1bpbuuppkj311a0q6tcn.jpg)