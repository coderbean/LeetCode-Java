### [77\. Combinations](https://leetcode.com/problems/combinations/)

Difficulty: **Medium**


Given two integers _n_ and _k_, return all possible combinations of _k_ numbers out of 1 ... _n_.

**Example:**

```
Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
```


#### Solution

Language: **Java**

```java
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combine(result, new ArrayList<Integer>(), 1, n, k);
        return result;
    }
​
    public void combine(List<List<Integer>> result, List<Integer> item, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = start; i <= n; i++) {
            item.add(i);
            combine(result, item, i + 1, n, k - 1);
            item.remove(item.size() - 1);
        }
    }
}
```
![](https://raw.githubusercontent.com/PicGoBed/PicBed/master/20190724214825.png)