### [90\. Subsets II](https://leetcode.com/problems/subsets-ii/)

Difficulty: **Medium**


Given a collection of integers that might contain duplicates, **_nums_**, return all possible subsets (the power set).

**Note:** The solution set must not contain duplicate subsets.

**Example:**

```
Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
```


#### Solution

Language: **Java**

```java
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elem = new ArrayList<>();
        result.add(elem);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int dupCount = 0;
            while (((i + 1) < nums.length) && nums[i + 1] == nums[i]) {
                dupCount++;
                i++;
            }
            int size = result.size();
            for (int j = 0; j < size; j++) {
                elem = new ArrayList<>(result.get(j));
                for (int k = 0; k <= dupCount; k++) {
                    elem.add(nums[i]);
                    result.add(new ArrayList<>(elem)); // 注意这里是要放在 for 循环里面的
                }
            }
        }
        return result;
    }
}
```
![pic](https://raw.githubusercontent.com/PicGoBed/PicBed/master/2019-08-03-1F2FZ6.jpg)