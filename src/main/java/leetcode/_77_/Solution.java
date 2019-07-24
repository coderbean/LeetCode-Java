package leetcode._77_;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        combine(result, new ArrayList<Integer>(), 1, n, k);
        return result;
    }

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