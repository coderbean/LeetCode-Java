### [39\. Combination Sum](https://leetcode.com/problems/combination-sum/)

Difficulty: **Medium**


Given a **set** of candidate numbers (`candidates`) **(without duplicates)** and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sums to `target`.

The **same** repeated number may be chosen from `candidates` unlimited number of times.

**Note:**

*   All numbers (including `target`) will be positive integers.
*   The solution set must not contain duplicate combinations.

**Example 1:**

```
Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
```

**Example 2:**

```
Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
```


#### Solution

Language: **Java**

```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<Integer> candidateSet = Arrays.stream(candidates).boxed().collect(Collectors.toCollection(TreeSet::new));
        return this.combinationSum(candidateSet, target);
    }
​
    // here def a new func to avoid calculate a new Set every time
    private List<List<Integer>> combinationSum(Set<Integer> candidateSet, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidateSet.contains(target)) {
            result.add(new ArrayList<>(Collections.singleton(target)));
        }
        for (Integer candidate : candidateSet) {
            int newTarget = target - candidate;
            if (newTarget < candidate) {
                return result;
            } else {
                for (List<Integer> list : this.combinationSum(candidateSet, newTarget)) {
                    // this ensure all result are desc sorted to avoid repetition
                    if (candidate <= list.get(list.size() - 1)) {
                        list.add(candidate);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }
}
```
![](https://ws1.sinaimg.cn/large/006tKfTcgy1g1bmizhcvoj310j0u0dkq.jpg)