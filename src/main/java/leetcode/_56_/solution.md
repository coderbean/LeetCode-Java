### [56\. Merge Intervals](https://leetcode.com/problems/merge-intervals/)

Difficulty: **Medium**


Given a collection of intervals, merge all overlapping intervals.

**Example 1:**

```
Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
```

**Example 2:**

```
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
```

**NOTE:** input types have been changed on April 15, 2019\. Please reset to default code definition to get new method signature.


#### Solution B

Language: **Java**

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals == null || intervals.length == 0) {
            return result.toArray(new int[result.size()][]);
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        // key 是数组的值，value 表示这个是左还是右，左为-1，右为1，如果都有，则求和
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            if (map.containsKey(left)) {
                map.put(left, map.get(left) - 1);
            } else {
                map.put(left, -1);
            }
            int right = intervals[i][1];
            if (map.containsKey(right)) {
                map.put(right, map.get(right) + 1);
            } else {
                map.put(right, 1);
            }
        }
        int[] interval = new int[2];
        interval[0] = intervals[0][0];
        int i = 0;
        for (Integer integer : map.keySet()) {
            if (i == 0) {
                interval = new int[2];
                interval[0] = integer;
            }
            i += map.get(integer);
            if (i == 0) {
                interval[1] = integer;
                result.add(interval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}

```
#### Solution B

Language: **Java**

```java
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {                             // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
```

![](http://ww2.sinaimg.cn/large/006tNc79ly1g4xeakhdjej31010u07bt.jpg)