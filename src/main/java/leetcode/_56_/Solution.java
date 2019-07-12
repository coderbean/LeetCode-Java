package leetcode._56_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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